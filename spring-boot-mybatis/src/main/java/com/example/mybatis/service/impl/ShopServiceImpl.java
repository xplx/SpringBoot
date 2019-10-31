package com.example.mybatis.service.impl;

import com.ace.cache.annotation.Cache;
import com.example.mybatis.mapper.ShopMapper;
import com.example.mybatis.model.Shop;
import com.example.mybatis.service.ShopService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2019/8/8 11:32
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopMapper shopMapper;

    @Override
    @Cache(key="shopInfo")
    public Shop list(Integer id) {
        Shop shop = shopMapper.selectByPrimaryKey(id);
        return shop;
    }
}
