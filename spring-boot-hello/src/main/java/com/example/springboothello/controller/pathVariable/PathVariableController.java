package com.example.springboothello.controller.pathVariable;

import com.example.springboothello.entity.User;
import com.example.springboothello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;

/**
 * @author wuxiaopeng
 * @create 2018-08-02 9:30
 * 注解 PathVariable 用于从请求 URL 中获取参数井映射到方法参数中.
 * 符号｛｝中的变量名与方法名字一一对应，如果不想对应,，
 * 则可以使用＠PathVariable(”id”) Long userld 来对应 。
 **/
@Controller
@RequestMapping("/user/{id}")
public class PathVariableController {
    @Autowired
    UserService userService;
    @GetMapping(path = "/{type}/get.json")
    @ResponseBody
    public User getUser(@PathVariable Long id, @PathVariable Integer type) {
        System.out.println("type:" + type);
        return userService.getUserById(id);
    }
}   