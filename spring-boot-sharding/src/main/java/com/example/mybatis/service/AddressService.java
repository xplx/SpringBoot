package com.example.mybatis.service;


import com.example.mybatis.model.Shop;
import com.example.mybatis.model.TAddress;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2019/8/8 11:31
 */
public interface AddressService {
    /**
     * @param id
     * @return
     */
    Object list(Long id);

    /**
     * 保存数据
     * @param address
     */
    void save(TAddress address);
}
