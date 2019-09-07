package com.example.springbootrabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:这是rabbitmq配置
 * @author:wuxiaopeng
 * @create: 2019-02-01 15:27
 **/
@Configuration
public class RabbitConfig {
    @Bean
    public Queue Queue() {
        System.out.println("测试使用！");
        return new Queue("hello");
    }
}
