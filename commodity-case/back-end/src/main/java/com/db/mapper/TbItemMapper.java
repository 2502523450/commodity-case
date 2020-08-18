package com.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.db.bean.TbItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * DESC: 映射类
 *
 * @author DB
 * @create 2020-08-14 10:21
 */
@Repository
public interface TbItemMapper extends BaseMapper<TbItem> {
}
