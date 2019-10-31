package com.example.mybatis.controller;

import com.example.mybatis.model.Shop;
import com.example.mybatis.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaopeng
 * @description: 测试
 * @date 2019/8/8 11:30
 */
@RestController
@Slf4j
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @GetMapping("/list")
    public Shop list(Integer id){
        Shop shop = shopService.list(id);
        return shop;
    }
}
