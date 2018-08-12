package com.example.druid.controller;

import com.example.druid.pojo.Users;
import com.example.druid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("th")
public class ThymeleafController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "thymeleaf-imooc");
        return "thymeleaf/index";
    }
    @RequestMapping
    public String getAllUserInfo(){
        return "thymeleaf/test";
    }
	
	@RequestMapping("center")
    public String center() {
        return "thymeleaf/center/center";
    }

    @RequestMapping("test")
    public String test(ModelMap map) {

        List<Users> userList = userService.getAllUsersInfo();
        map.addAttribute("userList", userList);

        return "thymeleaf/showUsers";
    }
}