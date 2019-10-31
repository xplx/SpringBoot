package com.example.springbootcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 在我们不使用其他第三方缓存依赖的时候，
 * springboot自动采用ConcurrenMapCacheManager作为缓存管理器
 * @author wuxiaopeng
 * @date 2019-6-19
 */
@EnableCaching
@SpringBootApplication
public class SpringBootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheApplication.class, args);
    }

}
