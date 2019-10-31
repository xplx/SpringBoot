package com.example.springbootdocker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
        for(int i=0;i<100;i++) {
            log.info("输出info  ");
            log.debug("输出debug+skkkw嗡嗡嗡kw");
            log.error("输出error  嗡嗡嗡我");
        }
        return "Hello Docker!";
    }
    @RequestMapping("/")
    public String home() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        log.info("Spring Boot Hello Docker World");
        for(int i=0;i<100;i++) {
            log.info("输出info  ");
            log.debug("输出debug+skkkw嗡嗡嗡kw");
            log.error("输出error  嗡嗡嗡我");
        }
        return "Spring Boot Hello Docker World:" + env+"ip:" + address.getHostAddress();
    }
}
