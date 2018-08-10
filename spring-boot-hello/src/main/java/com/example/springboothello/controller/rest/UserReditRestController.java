package com.example.springboothello.controller.rest;

import com.example.springboothello.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wuxiaopeng
 * @create 2018-08-01 14:33
 * 阻STFul 只是一种架构风格，并不是一种特别的技术体系 。
 * 1. 分组@Validated：提供了一个分组功能，可以在入参验证时，根据不同的分组采用不同的验证机制，这个网上也有资料，不详述。
 * @Valid：作为标准JSR-303规范，还没有吸收分组的功能。
 *2. 注解地方
 *@Validated：可以用在类型、方法和方法参数上。但是不能用在成员属性（字段）上
 *@Valid：可以用在方法、构造函数、方法参数和成员属性（字段）上
 *两者是否能用于成员属性（字段）上直接影响能否提供嵌套验证的功能。
 **/
@RestController
@RequestMapping(value = "/user")
public class UserReditRestController {
    @RequestMapping(value = "/userCredit")
    public Integer getCreditLevel(@Validated(User.Update.class) User user, BindingResult result){
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            FieldError error = (FieldError)list.get(0);
            System.out.println(error.getObjectName()+","+error.getField()+","+error.getDefaultMessage());
        }
        System.out.println("用户id：" + user.getId()+ "用户姓名：" + user.getName() + "时间：" + user.getTime());
        return 3;
    }
}   