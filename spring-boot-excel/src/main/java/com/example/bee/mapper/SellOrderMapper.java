package com.example.bee.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface SellOrderMapper {
    List<Map<String, Object>>selectOrderBuyInfo();
}