package com.example.mybatis.service.impl;


import com.example.mybatis.mapper.ShopMapper;
import com.example.mybatis.mapper.TAddressMapper;
import com.example.mybatis.model.Shop;
import com.example.mybatis.model.TAddress;
import com.example.mybatis.service.AddressService;
import com.example.mybatis.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2019/8/8 11:32
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private TAddressMapper tAddressMapper;

    @Override
    public Object list(Long id) {
        return tAddressMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(TAddress address) {
        tAddressMapper.insertSelective(address);
    }
}
