package com.wayeal.controller;

import com.wayeal.service.SiteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CompletableFuture;

/**
 * @version 1.0
 * @Author: tyf
 * @Date: 2022/06/20/14:04
 * @Description:
 */

@EnableAutoConfiguration
public class AsyncConsumer {

    @Reference(version = "async")
    private SiteService siteService;

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(AsyncConsumer.class);
        SiteService siteService = (SiteService) context.getBean(SiteService.class);
        //调用异步方法
        CompletableFuture<String> future = siteService.siteNameAsync("wayeal");
        //设置监听，非阻塞
        future.whenComplete((v, e) ->{
            if (e!=null){
                e.printStackTrace();
            } else {
                System.out.println("result:" + v);
            }
        });
        System.out.println("异步调用结束");
    }
}
