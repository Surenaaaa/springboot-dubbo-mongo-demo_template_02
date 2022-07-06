package com.wayeal.service;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author: tyf
 * @Date: 2022/06/17/18:09
 * @Description:
 */
public class SiteServiceListenerImpl implements SiteServiceListener, Serializable {
    @Override
    public void changed(String data) {
        System.out.println("changed:" + data);
    }
}
