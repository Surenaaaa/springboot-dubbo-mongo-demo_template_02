package com.wayeal.service.impl;

import com.wayeal.service.SiteService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.protocol.rest.support.ContentType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * @version 1.0
 * @Author: tyf
 * @Date: 2022/06/20/15:42
 * @Description:
 */

//@Service(version = "rest", protocol = "protocol4")
@Path("site")
public class RestSiteServiceImpl implements SiteService {
    @Override
    @GET
    @Path("name")
    @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8})
    public String siteName(@QueryParam("name") String name) {
        return "rest:" + name;
    }
}
