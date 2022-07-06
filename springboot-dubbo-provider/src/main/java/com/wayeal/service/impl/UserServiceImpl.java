package com.wayeal.service.impl;

import com.wayeal.pojo.User;
import com.wayeal.service.UserService;
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
 * @Date: 2022/06/16/10:47
 * @Description:
 */

@Service(version = "basis")
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * @Description: 添加用户信息
     * @Param: user
     * @return: 无
     * @Author: tyf
     * @Date: 2022/6/16
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
     * @Date: 2022/6/16
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
     * @Date: 2022/6/16
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
     * @Description: 查询全部用户信息
     * @Param:
     * @return: all
     * @Author: tyf
     * @Date: 2022/6/16
     */
    @Override
    public List<User> findAll() {
        List<User> all = mongoTemplate.findAll(User.class);
        return all;
    }

    /**
     * @Description: 根据id查询
     * @Param: id
     * @return: List
     * @Author: tyf
     * @Date: 2022/6/16
     */
    @Override
    public List<User> findById(Integer id) {
        Query query = new Query(Criteria.where("_id").is(id));
        List<User> list = mongoTemplate.find(query, User.class);
        return list;
    }


//        废弃代码，不过存在参考价值
//        list.forEach(System.out::println);
//        System.out.println("000000000000000000000000000");
//        List<String> companyList = list.stream().map(Staff::getCompany).distinct().collect(Collectors.toList());
//        companyList.forEach(System.out::println);
//        System.out.println("000000000000000000000000000");
//        List<String> departmentList = list.stream().map(Staff::getDepartment).distinct().collect(Collectors.toList());
//        departmentList.forEach(System.out::println);

//        MatchOperation match = Aggregation.match(criteria);
//        GroupOperation department = Aggregation.group("company","department","staffName").push("name").as("staffName");
//
//        GroupOperation c= Aggregation.group("company","department","staffName");
//
//        GroupOperation company = Aggregation.group(new String[] {"company"}).push("_id.department").as("department");
//
//        GroupOperation c2= Aggregation.group(new String[] {"company","department","staffName"});
//
//        TypedAggregation<Staff> staffTypedAggregation = Aggregation.newAggregation(Staff.class, match, department,c);
//
//        AggregationResults<Map> aggregationResults = mongoTemplate.aggregate(staffTypedAggregation, Map.class);
//
//        List<Map> mappedResults = aggregationResults.getMappedResults();

}
