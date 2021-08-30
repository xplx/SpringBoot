package com.example.seed.controller;

import com.example.seed.version.ApiVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaopeng
 * @date 2021年07月29日 10:40
 * @description
 */
@ApiVersion(1)
@RestController
@RequestMapping("{version}/hello")
public class Version1Controller {

    @RequestMapping("/world1")
    public String helloWorld(){
        System.out.println("版本是2的接口");
        return "hello,world .version is 2";
    }
}
