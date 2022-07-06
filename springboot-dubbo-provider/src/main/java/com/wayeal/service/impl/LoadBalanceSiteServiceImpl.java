package com.wayeal.service.impl;

import com.wayeal.service.SiteService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @version 1.0
 * @Author: tyf
 * @Date: 2022/06/20/14:25
 * @Description:
 */

@Service(version = "balance", loadbalance = "roundrobin")
public class LoadBalanceSiteServiceImpl implements SiteService {
    @Override
    public String siteName(String name) {
//        return null;

        URL url = RpcContext.getContext().getUrl();
        return String.format("%s:%s,Hello, %s", url.getProtocol(), url.getPort(), name);
    }
}
