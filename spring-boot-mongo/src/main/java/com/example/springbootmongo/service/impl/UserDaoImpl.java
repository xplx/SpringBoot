package com.example.springbootmongo.service.impl;

import com.example.springbootmongo.entity.UserEntity;
import com.example.springbootmongo.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @Description:user的实现类
 * @author:wuxiaopeng
 * @create: 2019-02-02 9:26
 **/
@Service
public class UserDaoImpl implements UserDao{
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建对象
     * @param user
     */
    @Override
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     * @param userName
     * @return
     */
    @Override
    public UserEntity findUserByPassWord(String userName) {
        //这里设置条件
        Query query = new Query(Criteria.where("passWord").is(userName));
        UserEntity user =  mongoTemplate.findOne(query , UserEntity.class);
        return user;
    }

    /**
     * 更新对象
     * @param user
     */
    @Override
    public void updateUser(UserEntity user) {
        //设置查询条件
        Query query=new Query(Criteria.where("userName").is(user.getUserName()));
        //更新数据
        Update update= new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,UserEntity.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    /**
     * 删除对象
     * @param id
     */
    @Override
    public void deleteUserById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,UserEntity.class);
    }
}
