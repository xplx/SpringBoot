package com.example.mybatis.service;


import com.example.mybatis.model.Shop;
import com.example.mybatis.model.User;

import java.util.List;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2019/8/8 11:31
 */
public interface UserService {
    /**
     * 获取user信息
     * @return
     */
    List<User> list(Integer id);

    /**
     * 添加用户信息
     * @param user
     */
    Integer addUser(User user);
}
