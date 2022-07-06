package com.wayeal.service.impl;

import com.wayeal.pojo.User;
import com.wayeal.service.UserService_PropertiesTest;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @version 1.0
 * @Author: tyf
 * @Date: 2022/06/17/11:16
 * @Description:
 */

@Service(version = "1.0", timeout = 3000, retries = 2, weight = 100, protocol = "protocol1")
public class UserService_PropertiesTestImpl_V1 implements UserService_PropertiesTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * @Description: 查询全部用户信息
     * @Param:
     * @return: all
     * @Author: tyf
     * @Date: 2022/6/17
     */
    int i = 1;

    @Override
    public List<User> findAll() throws InterruptedException {
        System.out.println("version 1.0 服务被调用了：" + i++ + "次");
        List<User> all = mongoTemplate.findAll(User.class);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return all;
    }

    /**
     * @Description: 添加用户信息
     * @Param: user
     * @return: 无
     * @Author: tyf
     * @Date: 2022/6/17
     */
    @Override
    public void save(User user) {
        mongoTemplate.save(user);
    }

    /**
     * @Description: 根据id删除用户
     * @Param: id
     * @return: 无
     * @Author: tyf
     * @Date: 2022/6/17
     */
    @Override
    public void delete(Integer id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, User.class);
    }

    /**
     * @Description: 修改用户信息
     * @Param:
     * @return:
     * @Author: tyf
     * @Date: 2022/6/17
     */
    @Override
    public void update(Integer id, String name, Integer age, String pwd) {
        Query query = new Query(Criteria.where("_id").is(id));

        Update update1 = Update.update("name", name);
        mongoTemplate.updateFirst(query, update1, User.class);

        Update update2 = Update.update("age", age);
        mongoTemplate.updateFirst(query, update2, User.class);

        Update update3 = Update.update("pwd", pwd);
        mongoTemplate.updateFirst(query, update3, User.class);
    }

    /**
     * @Description: 根据id查询
     * @Param: id
     * @return: List
     * @Author: tyf
     * @Date: 2022/6/17
     */
    @Override
    public List<User> findById(Integer id) {
        Query query = new Query(Criteria.where("_id").is(id));
        List<User> list = mongoTemplate.find(query, User.class);
        return list;
    }
}
