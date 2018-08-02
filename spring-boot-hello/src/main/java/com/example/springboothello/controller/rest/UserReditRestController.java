package com.example.springboothello.controller.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaopeng
 * @create 2018-08-01 14:33
 * 阻STFul 只是一种架构风格，并不是一种特别的技术体系 。
 **/
@RestController
public class UserReditRestController {
    @RequestMapping(value = "/userCredit/{id}")
    public Integer getCreditLevel(@PathVariable String id){
        System.out.println("用户id：" + id);
        return 3;
    }
}   