package com.example.springbootexcel.mapper;

import com.example.springbootexcel.mode.TbSellOrder;
import com.example.springbootexcel.mode.TbSellOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TbSellOrderMapper {
    long countByExample(TbSellOrderExample example);

    int deleteByExample(TbSellOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSellOrder record);

    int insertSelective(TbSellOrder record);

    List<TbSellOrder> selectByExample(TbSellOrderExample example);

    TbSellOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSellOrder record, @Param("example") TbSellOrderExample example);

    int updateByExample(@Param("record") TbSellOrder record, @Param("example") TbSellOrderExample example);

    int updateByPrimaryKeySelective(TbSellOrder record);

    int updateByPrimaryKey(TbSellOrder record);
}