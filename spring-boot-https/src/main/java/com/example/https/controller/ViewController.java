package com.example.https.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:测试https
 * @author:wuxiaopeng
 * @create: 2019-01-22 15:27
 **/
@Controller
@RequestMapping
public class ViewController {
    @GetMapping("index")
    public String index(){
        return "index";
    }
}
