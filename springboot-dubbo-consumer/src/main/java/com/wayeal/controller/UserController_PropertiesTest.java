package com.wayeal.controller;

import com.wayeal.pojo.User;
import com.wayeal.service.UserService;
import com.wayeal.service.UserService_PropertiesTest;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author: tyf
 * @Date: 2022/06/17/11:23
 * @Description:
 */

@RestController
@RequestMapping("/user_test")
public class UserController_PropertiesTest {

//  服务降级 mock = "fail:return null"
//  负载均衡 loadbalance = "random"
//  超时重试 timeout = 3000,retries = 2
//  本地存根 stub = "true"

    @Reference(version = "2.0",mock = "fail:return null")
    private UserService_PropertiesTest userServicePropertiesTest;

    //超时重试属性
    @GetMapping("/findAll")
    public Object findAll() throws InterruptedException {
        return userServicePropertiesTest.findAll();
    }


    /**
     * @Description: 保存用户信息
     * @Param: user
     * @return: 保存成功
     * @Author: tyf
     * @Date: 2022/6/16 */
    @GetMapping("/save")
    public String save(User user) {
        userServicePropertiesTest.save(user);
        return "保存成功";
    }

    /**
     * @Description: 根据用户id删除
     * @Param: id
     * @return: 删除成功
     * @Author: tyf
     * @Date: 2022/6/16 */
    @GetMapping("/delete")
    public String delete(Integer id) {
        userServicePropertiesTest.delete(id);
        return "删除成功";
    }

    /**
     * @Description: 修改用户信息
     * @Param:
     * @return:
     * @Author: tyf
     * @Date: 2022/6/16 */
    @GetMapping("/update")
    public void update(Integer id, String name, Integer age, String pwd){
        userServicePropertiesTest.update(id,name,age,pwd);
        System.out.println("修改成功");
    }

    /**
     * @Description: 根据id查询
     * @Param: id
     * @return: User
     * @Author: tyf
     * @Date: 2022/6/16 */
    @GetMapping("/findById")
    public Object findById(Integer id){
        return userServicePropertiesTest.findById(id);
    }
}
