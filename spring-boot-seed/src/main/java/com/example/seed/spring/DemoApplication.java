package com.example.seed.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @author xiaopeng
 * @date 2021年03月25日 14:18
 * @description
 */
public class DemoApplication {
    @Autowired
    private BeanInitOrder beanInitOrder;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public void test() {
        System.out.println(beanInitOrder.getName());
    }
}
