package com.example.seed.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.example.seed.support.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/4/24 14:55
 */
@Api(tags = "redis管理 DruidStatController")
@RequestMapping("/redis")
@RestController
public class RedisController {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/get")
    @ApiOperation("获取redis数据")
    public Object getData(String key){
        return redisUtil.get(key);
    }

    @GetMapping("/save")
    @ApiOperation("保存redis数据")
    public Object saveData(String key,String value){
        SecureRandom random = new SecureRandom();
        redisUtil.set(key + random.nextInt(100000), value + random.nextInt(100000));
        return "OK";
    }
}
