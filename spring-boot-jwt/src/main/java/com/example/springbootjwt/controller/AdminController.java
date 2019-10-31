package com.example.springbootjwt.controller;

import com.example.springbootjwt.mode.User;
import com.example.springbootjwt.service.AdminService;
import com.example.springbootjwt.util.R;
import com.example.springbootjwt.util.jwt.IJWTInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author wuxiaopeng
 * @Date 2019-10-24
 */
@RestController
@Slf4j
@Api(tags = "用户登录")
public class AdminController {
    @Resource
    private AdminService adminService;


    @ApiOperation("获取token")
    @PostMapping(value = "token")
    public R<String> createAuthenticationToken(
            @RequestParam("password") String password,
            @RequestParam("username") String username) throws Exception {
        log.info("username:{}", password);
        log.info("password:{}", username);
        final String token = adminService.login(password, username);
        return R.ok().setData(token);
    }

    @ApiOperation("获取用户信息")
    @GetMapping(value = "getInfoFromToken")
    public R<IJWTInfo> getInfoFromToken(@RequestParam("token") String token) throws Exception {
        log.info("token:{}", token);
        IJWTInfo user = adminService.getInfoFromToken(token);
        return R.ok().setData(user);
    }

}
