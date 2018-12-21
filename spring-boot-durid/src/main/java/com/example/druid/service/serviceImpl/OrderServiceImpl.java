package com.example.druid.service.serviceImpl;

import com.example.druid.mapper.StatisticOrderMapper;
import com.example.druid.pojo.StatisticOrder;
import com.example.druid.pojo.Users;
import com.example.druid.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author :wxp
 * @date :2018/12/21
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private StatisticOrderMapper statisticOrderMapper;
    @Override
    public int saveOrderInfo(StatisticOrder statisticOrder){
        int result = statisticOrderMapper.insert(statisticOrder);
        return result;
    }
}
