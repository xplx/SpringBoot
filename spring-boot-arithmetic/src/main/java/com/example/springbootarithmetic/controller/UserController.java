package com.example.springbootarithmetic.controller;

import com.example.springbootarithmetic.mode.User;

import java.sql.SQLOutput;

/**
 * @author wuxiaopeng
 * @description: 控制类
 * @date 2019/7/2 16:12
 */
public class UserController {
    public static void main(String[] args) {
        User u = User.builder().build();
        System.out.println(u.getPassword());
    }
}
