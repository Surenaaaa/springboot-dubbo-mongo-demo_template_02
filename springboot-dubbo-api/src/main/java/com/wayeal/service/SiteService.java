package com.wayeal.service;

import java.util.concurrent.CompletableFuture;

/**
 * @version 1.0
 * @Author: tyf
 * @Date: 2022/06/17/18:05
 * @Description:
 */

public interface SiteService {

    //回调方法
    default String siteName(String name, String key, SiteServiceListener siteServiceListener) {
        return null;
    }

    //同步调用方法
    String siteName(String name);

    //异步调用方法
    default CompletableFuture<String> siteNameAsync(String name){
        return null;
    }
}
