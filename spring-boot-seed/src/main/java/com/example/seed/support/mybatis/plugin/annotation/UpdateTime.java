package com.example.seed.support.mybatis.plugin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wuxiaopeng
 * @description:更新时间的拦截器
 * @date 2020/4/15 14:10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface UpdateTime {
    String value() default "";
}
