package com.example.springbootjwt.service.impl;

import com.ace.cache.annotation.Cache;
import com.alibaba.fastjson.JSON;
import com.example.springbootjwt.mode.User;
import com.example.springbootjwt.service.AdminService;
import com.example.springbootjwt.support.config.KeyConfiguration;
import com.example.springbootjwt.util.jwt.IJWTInfo;
import com.example.springbootjwt.util.jwt.JWTInfo;
import com.example.springbootjwt.util.jwt.JwtTokenUtil;
import com.example.springbootjwt.util.jwt.UserAuthUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2019/10/24 14:41
 */
@Service
public class AdminServiceImp implements AdminService {
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Resource
    private UserAuthUtil userAuthUtil;


    @Override
    public String login(String password, String username) throws Exception {
        User user = validate(password, username);
        String token = jwtTokenUtil.generateToken(new JWTInfo(password, "1", username));
        //将其变成json格式MyFilter
        String result = JSON.toJSONString(user, false);
        redisTemplate.opsForValue().set(token, result);
        return token;
    }

    @Override
    public IJWTInfo getInfoFromToken(String token) throws Exception {
        IJWTInfo userInfo = userAuthUtil.getInfoFromToken(token);
        return userInfo;
    }

    public User validate(String password, String username){
        User user = new User();
        user.setId(1);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

}
