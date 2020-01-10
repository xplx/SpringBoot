package com.example.demo.user.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo.user.entity.User;
import com.example.demo.user.service.IUserService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuxiaopeng
 * @since 2020-01-06
 */
@RestController
@RequestMapping("/user/user")
public class UserController {
    @Resource
    private IUserService iUserService;

    @PostMapping("/add")
    public R add(@Validated @RequestBody User user, BindingResult bindingResult) {
        try{
            iUserService.save(user);
        }catch (Exception e) {
            e.printStackTrace();
            return R.failed("异常");
        }
        return R.ok("success");
    }

    @PostMapping("/get")
    public R get(User user) {
        try{
            iUserService.listObjs(Wrappers.<User>lambdaQuery().eq(User::getEmail, 1));
        }catch (Exception e) {
            e.printStackTrace();
            return R.failed("异常");
        }
        return R.ok("success");
    }
}
