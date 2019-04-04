package com.gzdsy.gogbee.bee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GogbeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GogbeeApplication.class, args);
    }

}

