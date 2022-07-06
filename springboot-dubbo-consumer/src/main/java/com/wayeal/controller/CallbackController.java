package com.wayeal.controller;

import com.wayeal.service.SiteService;
import com.wayeal.service.SiteServiceListenerImpl;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author: tyf
 * @Date: 2022/06/17/18:20
 * @Description:
 */

@EnableAutoConfiguration
public class CallbackController {

    @Reference(version = "callback")
    private SiteService siteService;

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(CallbackController.class);
        SiteService siteService = (SiteService) context.getBean(SiteService.class);
//        key 目的是指明实现类在服务提供者和消费者之间保证是同一个
        System.out.println(siteService.siteName("wayeal","c1",new SiteServiceListenerImpl()));
//        System.out.println(siteService.siteName("wayeal","c2",new SiteServiceListenerImpl()));
//        System.out.println(siteService.siteName("wayeal","c3",new SiteServiceListenerImpl()));

    }

}
