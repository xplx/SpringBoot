package com.example.seed.controller;

import com.example.seed.model.entity.User;
import com.example.seed.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuxiaopeng
 * @date 2020/03/26
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(tags = "UserController")
public class UserController extends BaseController<UserService, User> {
    @Resource
    private UserService userService;
}
