package com.wayeal.service;

import com.wayeal.pojo.User;

import java.util.List;

/**
 * @version 1.0
 * @Author: tyf
 * @Date: 2022/06/17/11:15
 * @Description:
 */
public interface UserService_PropertiesTest {

    void save(User user);

    void delete(Integer id);

    void update(Integer id, String name, Integer age, String pwd);

    List<User> findAll() throws InterruptedException;

    List<User> findById(Integer id);

}
