package com.example.springboothello.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Service;

/**
 * @author wuxiaopeng
 * @create 2018-08-01 14:19
 **/
@Controller
//默认输出级别为info
@Slf4j
public class HelloWorldController {
    @RequestMapping("sayHello.html")
    @ResponseBody //表示此方法返回的是文本而不是视图名称。
    public String say(){
        log.info("Hello Spring Boot");
        log.debug("debug message");
        log.warn("warn message");
        log.info("info message");
        log.error("error message");
        log.trace("trace message");
        return "Hello Spring Boot";
    }

}   