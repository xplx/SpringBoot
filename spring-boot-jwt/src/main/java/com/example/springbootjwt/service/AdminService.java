package com.example.springbootjwt.service;

import com.example.springbootjwt.mode.User;
import com.example.springbootjwt.util.jwt.IJWTInfo;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2019/10/24 14:41
 */
public interface AdminService{
    /**
     * 登录
     * @param password
     * @param username
     * @return
     */
    String login(String password, String username) throws Exception;

    /**
     * 解析用户信息
     * @param token
     * @return
     */
    IJWTInfo getInfoFromToken(String token) throws Exception;
}
