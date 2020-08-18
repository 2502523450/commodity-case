package com.db.client;

import com.db.bean.TbItem;
import com.db.bean.TbItemVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * DESC:
 *
 * @author DB
 * @create 2020-08-15 10:14
 */
@Component
@FeignClient(value = "service-provider")
public interface TbItemClient {
    @RequestMapping("TbItem/findAll/{current}/{size}")//补全全局路径
    public TbItemVo findAll(@PathVariable("current") Integer current, @PathVariable("size") Integer size);

    @RequestMapping("TbItem/findById/{id}")
    public TbItem findById(@PathVariable("id") Long id);

    @RequestMapping("TbItem/delete/{id}")
    public String delete(@PathVariable("id") Long id);


    @RequestMapping("TbItem/insertOrUpdate")
    public String insertOrUpdate(@RequestBody TbItem tbItem);

//    @RequestMapping("TbItem/update/{id}")
//    public String update(@PathVariable("id") String id, @RequestBody TbItem tbItem);

    @RequestMapping("TbItem/findOne/{search}")
    public List<TbItem> findOne(@PathVariable("search") String one);

    @RequestMapping("TbItem/findByPoint/{point}")
    public List<TbItem> findByPoint(@PathVariable("point") String one);


}
