package com.example.bee.service.impl;

import com.example.bee.mapper.SellOrderMapper;
import com.example.bee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-04-08 11:44
 **/
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private SellOrderMapper sellOrderMapper;
    @Override
    public List<Map<String, Object>> findOrderBuyInfo(){
        List<Map<String, Object>> mapList = sellOrderMapper.selectOrderBuyInfo();
        return mapList;
    }

}
