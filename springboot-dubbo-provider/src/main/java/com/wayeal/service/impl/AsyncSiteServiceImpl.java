package com.wayeal.service.impl;

import com.wayeal.service.SiteService;
import com.wayeal.service.SiteServiceListener;
import org.apache.dubbo.config.annotation.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @version 1.0
 * @Author: tyf
 * @Date: 2022/06/20/14:00
 * @Description:
 */
@Service(version = "async", protocol = "protocol1")
public class AsyncSiteServiceImpl implements SiteService {

    @Override
    public String siteName(String name) {
        return "async:" + name;
    }

    @Override
    public CompletableFuture<String> siteNameAsync(String name) {
        System.out.println("异步调用：" + name);
        return CompletableFuture.supplyAsync(() -> {
            return siteName(name);
        });
    }
}
