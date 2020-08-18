package com.db.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DESC:配置类
 *
 * @author DB
 * @create 2020-08-14 10:27
 */
@Configuration
@MapperScan("com.db.mapper")
public class TbItemConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
