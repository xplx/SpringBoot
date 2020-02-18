package com.example.seed.support.param;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * tk查询条件设置
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MapperParamCondition {
    /**
     * 表字段名称
     * @return
     */
    String entityName() default "";

    /**
     * 条件类型:>、=、<、!=、like、in等查询条件
     * @return
     */
    String pattern();

    /**
     * and或者or连接查询条件
     * @return
     */
    String patternType() default "and";

    /**
     *   匹配模糊查询：before前匹配，after后匹配，all前后匹配
     * @return
     */
    String fuzzyPosition() default "";
}
