package com.example.mybatis.controller;


import com.example.mybatis.model.Shop;
import com.example.mybatis.model.User;
import com.example.mybatis.service.ShopService;
import com.example.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaopeng
 * @description: 测试
 * @date 2019/8/8 11:30
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService UserService;

    @GetMapping("/list")
    public Object list(Integer id) {
        return UserService.list(id);
    }

    @GetMapping("/add")
    public Object add() {
        for (int i = 100; i < 150; i++) {
            User user = new User();
            user.setId(i);
            user.setUsername("forezp" + (i));
            user.setPassword("1233edwd");
            Integer result = UserService.addUser(user);
            log.info("insert:" + user.toString() + " result:" + result);
        }
        return "ok";
    }
}
