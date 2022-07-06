package com.wayeal.service.impl;

import com.wayeal.service.SiteService;
import com.wayeal.service.SiteServiceListener;
import org.apache.dubbo.config.annotation.Argument;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;

/**
 * @version 1.0
 * @Author: tyf
 * @Date: 2022/06/17/18:11
 * @Description:
 */

@Service(version = "callback", methods = {@Method(name = "siteName", arguments = {@Argument(index = 2, callback = true)})}, protocol = "protocol1")
public class CallbackSiteServiceImpl implements SiteService {

    @Override
    public String siteName(String name, String key, SiteServiceListener siteServiceListener) {
        siteServiceListener.changed("provider data");
        return "callback" + name;
    }

    @Override
    public String siteName(String name) {
        return null;
    }

}
