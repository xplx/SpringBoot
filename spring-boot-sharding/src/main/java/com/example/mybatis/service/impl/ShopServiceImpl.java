package com.example.mybatis.service.impl;


import com.example.mybatis.mapper.ShopMapper;
import com.example.mybatis.model.Shop;
import com.example.mybatis.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public Shop list(Integer id) {
        return shopMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Shop shop) {
        shopMapper.insertSelective(shop);
    }
}
