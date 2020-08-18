package com.db.controller;

import com.db.bean.TbItem;
import com.db.bean.TbItemVo;
import com.db.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * DESC:
 *
 * @author DB
 * @create 2020-08-14 13:54
 */
@RestController
@CrossOrigin
@RequestMapping("TbItem")
public class TbItemController {
    @Autowired
    private TbItemService tbItemService;

    @RequestMapping("findAll/{current}/{size}")
    public TbItemVo findAll(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        TbItemVo tbItemVo = tbItemService.findAll(current, size);
        return tbItemVo;
    }

    @RequestMapping("findById/{id}")
    public TbItem findById(@PathVariable("id") Long id) {
        return tbItemService.findById(id);
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        String delete = tbItemService.delete(id);
        return delete;
    }

    @RequestMapping("insertOrUpdate")
    public String insertOrUpdate(@RequestBody TbItem tbItem) {
        String insert = tbItemService.insertOrUpdate(tbItem);
        return insert;
    }

//    @RequestMapping("update/{id}")
//    public String update(@PathVariable("id") long id, @RequestBody TbItem tbItem) {
//        tbItemService.update(id, tbItem);
//        return null;
//    }

    @RequestMapping("findOne/{search}")
    public List<TbItem> findOne(@PathVariable("search") String one) {
        return tbItemService.findOne(one);
    }

    //根据卖点查询
    @RequestMapping("findByPoint/{point}")
    public List<TbItem> findByPoint(@PathVariable("point") String one) {
        return tbItemService.findByPoint(one);
    }
}
