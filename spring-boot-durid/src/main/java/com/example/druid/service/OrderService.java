package com.example.druid.service;

import com.example.druid.pojo.StatisticOrder;
import com.example.druid.pojo.Users;

import java.util.List;

/**
 * @author :wxp
 * @date :2018/12/21
 */
public interface OrderService {
    /**
     * 保存订单信息
     * @return
     */
    int saveOrderInfo(StatisticOrder statisticOrder);
}
