package com.example.springbootcache.annotation;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wuxiaopeng
 * @description: 在需要保证 接口幂等性 的Controller的方法上使用此注解
 * @date 2020/1/9 10:44
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiIdempotent {
}
