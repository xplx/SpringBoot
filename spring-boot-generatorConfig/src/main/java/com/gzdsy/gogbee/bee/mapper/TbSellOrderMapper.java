package com.gzdsy.gogbee.bee.mapper;

import com.gzdsy.gogbee.bee.model.TbSellOrder;
import com.gzdsy.gogbee.bee.model.TbSellOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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