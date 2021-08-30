package com.example.seed.support.resubmit;

import java.lang.annotation.*;

/**
 * @author xiaopeng
 * @author xiaopeng
 * @date
 * @descipe 这个只能本地使用，分布式时不能使用
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Resubmit {
    /**
     * 延时时间 在延时多久后可以再次提交
     * *
     @return Time unit is one second
     */
    int delaySeconds() default 20;
}
