package com.example.mybatis.service.impl;


import com.example.mybatis.mapper.ShopMapper;
import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.model.Shop;
import com.example.mybatis.model.User;
import com.example.mybatis.model.UserExample;
import com.example.mybatis.service.ShopService;
import com.example.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2019/8/8 11:32
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> list(Integer id) {
        UserExample example = new UserExample();
        if (id != 0) {
            example.createCriteria().andIdEqualTo(id);
        }
        example.setOrderByClause("id asc");
        return userMapper.selectByExample(example);
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.insertSelective(user);
    }
}
