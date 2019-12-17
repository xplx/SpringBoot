package com.example.mybatis.controller;


import com.example.mybatis.model.Shop;
import com.example.mybatis.model.TAddress;
import com.example.mybatis.service.AddressService;
import com.example.mybatis.service.ShopService;
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
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public Object list(Long id){
        return addressService.list(id);
    }

    @PostMapping("/save")
    public void save(TAddress address){
        addressService.save(address);
    }
}
