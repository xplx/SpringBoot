package com.example.druid.mapper;

import com.example.druid.pojo.StatisticOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StatisticOrder record);

    int insertSelective(StatisticOrder record);

    StatisticOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StatisticOrder record);

    int updateByPrimaryKey(StatisticOrder record);
}