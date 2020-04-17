package com.example.seed.support.mybatis.plugin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wuxiaopeng
 * @description: 创建时间拦截器
 * @date 2020/4/15 14:09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface CreateTime {
    String value() default "";
}
