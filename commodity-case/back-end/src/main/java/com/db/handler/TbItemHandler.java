package com.db.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * DESC:自动填充工具类
 *
 * @author DB
 * @create 2020-08-14 10:57
 */
@Component
public class TbItemHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("created",new Date(),metaObject);
        this.setFieldValByName("updated",new Date(),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updated",new Date(),metaObject);

    }
}
