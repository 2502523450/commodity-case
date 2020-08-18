package com.db.controller;

import com.db.bean.TbItem;
import com.db.bean.TbItemVo;
import com.db.client.TbItemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * DESC:
 *
 * @author DB
 * @create 2020-08-15 10:28
 */
@CrossOrigin
@RequestMapping("TbItem")
@RestController
public class ItemController {
    @Autowired
    private TbItemClient tbItemClient;

    @RequestMapping("findAll/{current}/{size}")
    public TbItemVo findAll(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        TbItemVo list = tbItemClient.findAll(current, size);
        return list;
    }

    @RequestMapping("findById/{id}")
    public TbItem findById(@PathVariable("id") Long id) {
        return tbItemClient.findById(id);
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        String delete = tbItemClient.delete(id);
        return delete;
    }

    @RequestMapping("insertOrUpdate")
    public String insertOrUpdate(@RequestBody TbItem tbItem) {
        String insert = tbItemClient.insertOrUpdate(tbItem);
        return insert;
    }

//    @RequestMapping("update/{id}")
//    public String update(@PathVariable("id") String id, @RequestBody TbItem tbItem) {
//        String update = tbItemClient.update(id, tbItem);
//        return update;
//    }

    @RequestMapping("findOne/{search}")
    public List<TbItem> findOne(@PathVariable("search") String one) {
        return tbItemClient.findOne(one);
    }

    @RequestMapping("findByPoint/{point}")
    public List<TbItem> findByPoint(@PathVariable("point") String one) {
        return tbItemClient.findByPoint(one);
    }
}
