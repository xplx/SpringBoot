package com.example.mybatis.service;

import com.example.mybatis.model.Shop;

import java.util.List;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2019/8/8 11:31
 */
public interface ShopService {
    /**
     * 获取shop信息
     * @param id
     * @return
     */
    List<Shop> list(Integer id);
}
