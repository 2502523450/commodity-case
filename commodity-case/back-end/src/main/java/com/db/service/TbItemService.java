package com.db.service;

import com.db.bean.TbItem;
import com.db.bean.TbItemVo;

import java.util.List;

/**
 * DESC:
 *
 * @author DB
 * @create 2020-08-14 11:40
 */
public interface TbItemService {
    //查询所有
    public TbItemVo findAll(Integer current, Integer size);

    //单一查询
    public TbItem findById(Long id);

    //添加
    public String insertOrUpdate(TbItem tbItem);

    //删除
    public String delete(Long id);

//    //修改
//    public String update(long id,TbItem tbItem);

    //条件查询
    public List<TbItem> findOne(String one);

    //卖点条件查询
    public List<TbItem> findByPoint(String one);

}
