package com.example.springboothello.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Service;

/**
 * @author wuxiaopeng
 * @create 2018-08-01 14:19
 **/
@Controller
public class HelloWorldController {
    @RequestMapping("sayHello.html")
    @ResponseBody //表示此方法返回的是文本而不是视图名称。
    public String say(){
        return "Hello Spring Boot";
    }

}   