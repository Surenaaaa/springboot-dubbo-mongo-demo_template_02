package com.wayeal.controller;

import com.wayeal.service.SiteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @version 1.0
 * @Author: tyf
 * @Date: 2022/06/20/14:33
 * @Description:
 */
@EnableAutoConfiguration
public class LoadBalanceConsumer {

    @Reference(version = "balance",loadbalance = "roundrobin")
    private SiteService siteService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LoadBalanceConsumer.class);
        SiteService siteService = (SiteService) context.getBean(SiteService.class);

//        roundrobin
        for (int i = 0; i < 30; i++) {
            String name = siteService.siteName("wayeal");
            System.out.println(name);
        }

    }


}
