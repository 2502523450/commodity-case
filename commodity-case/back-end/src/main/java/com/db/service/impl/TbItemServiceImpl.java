package com.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.db.bean.TbItem;
import com.db.bean.TbItemVo;
import com.db.mapper.TbItemMapper;
import com.db.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DESC:
 *
 * @author DB
 * @create 2020-08-14 13:43
 */
@Service
public class TbItemServiceImpl implements TbItemService {
    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public TbItemVo findAll(Integer current, Integer size) {
        Page<TbItem> userPage = new Page<>(current, size);//参数一是当前页，参数二是每页个数
        userPage = tbItemMapper.selectPage(userPage, null);
        TbItemVo userVo = new TbItemVo();
        List<TbItem> list = userPage.getRecords();
        long total = userPage.getTotal();
        userVo.setTbItems(list);
        userVo.setTotal(total);
        return userVo;
    }

    @Override
    public TbItem findById(Long id) {
        TbItem tbItem = tbItemMapper.selectById(id);
        return tbItem;
    }

    @Override
    public String insertOrUpdate(TbItem tbItem) {
        Long id = tbItem.getId();
        if (id != null) {
             tbItemMapper.updateById(tbItem);
        } else {
             tbItemMapper.insert(tbItem);
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        TbItem tbItem = tbItemMapper.selectById(id);
        System.out.println(tbItem);
        tbItem.setStatus(3);
        int i = tbItemMapper.updateById(tbItem);
        return null;
    }

//    @Override
//    public String update(long id, TbItem tbItem) {
//        tbItem.setId(id);
//        tbItemMapper.updateById(tbItem);
//        return null;
//    }

    @Override
    public List<TbItem> findOne(String one) {
        QueryWrapper<TbItem> queryWrapper = new QueryWrapper<>();
        QueryWrapper<TbItem> title = queryWrapper.like("title", one);
        List<TbItem> tbItems = tbItemMapper.selectList(title);
        return tbItems;
    }

    @Override
    public List<TbItem> findByPoint(String one) {
        QueryWrapper<TbItem> queryWrapper = new QueryWrapper<>();
        QueryWrapper<TbItem> sellPoint = queryWrapper.like("sell_point", one);
        List<TbItem> tbItems = tbItemMapper.selectList(sellPoint);
        return tbItems;
    }

}
