package com.example.seed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.FeignClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wuxiaopeng
 * @date 2020-01-18
 * @ComponentScan :默认Spring框架实现会从声明@ComponentScan所在类的package进行扫描。
 * @EnableAutoConfiguration:
 */
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = {"com.example.seed.mapper"})
public class SpringBootSeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSeedApplication.class, args);
    }
}
