package com.example.seed.model.convert;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Description:对象转换,用于对象转换时，复用代码
 * @author: XiaoPeng Wu
 * @create: 2021-12-10 10:16
 **/
@Retention(RetentionPolicy.CLASS)
@Mapping(target = "creationDate", expression = "java(new java.util.Date())")
public @interface ToEntity {
}
