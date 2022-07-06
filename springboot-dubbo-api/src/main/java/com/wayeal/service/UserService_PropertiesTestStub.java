package com.wayeal.service;

import com.wayeal.pojo.User;

import java.util.List;

/**
 * @version 1.0
 * @Author: tyf
 * @Date: 2022/06/17/17:03
 * @Description:
 */
public class UserService_PropertiesTestStub implements UserService_PropertiesTest{

    private final UserService_PropertiesTest userServicePropertiesTest;

    public UserService_PropertiesTestStub(UserService_PropertiesTest userServicePropertiesTest) {
        this.userServicePropertiesTest = userServicePropertiesTest;
    }

    @Override
    public List<User> findAll() throws InterruptedException {

        try {
            return userServicePropertiesTest.findAll();
        }catch (Exception e){
            System.out.println("本地存根");
            return null;
        }

    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Integer id, String name, Integer age, String pwd) {

    }

    @Override
    public List<User> findById(Integer id) {
        return null;
    }

}
