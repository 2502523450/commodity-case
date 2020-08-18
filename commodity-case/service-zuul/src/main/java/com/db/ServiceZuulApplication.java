package com.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy//启用zuul组件
public class ServiceZuulApplication {


    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }

}
