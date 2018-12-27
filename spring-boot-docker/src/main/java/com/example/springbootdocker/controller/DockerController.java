package com.example.springbootdocker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * DockerController class
 *
 * @author wuxiaopeng
 * @date 2018/12/27
 */
@Slf4j
@RestController
public class DockerController {
    @Value("${env.value}")
    private String env;

    @RequestMapping("/index")
    public String index() {
        return "Hello Docker!";
    }
    @RequestMapping("/")
    public String home() {
        log.info("Spring Boot Hello Docker World");
        return "Spring Boot Hello Docker World:" + env;
    }
}
