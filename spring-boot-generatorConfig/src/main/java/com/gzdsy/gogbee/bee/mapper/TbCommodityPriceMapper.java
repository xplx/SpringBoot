package com.gzdsy.gogbee.bee.mapper;

import com.gzdsy.gogbee.bee.model.TbCommodityPrice;
import com.gzdsy.gogbee.bee.model.TbCommodityPriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCommodityPriceMapper {
    long countByExample(TbCommodityPriceExample example);

    int deleteByExample(TbCommodityPriceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbCommodityPrice record);

    int insertSelective(TbCommodityPrice record);

    List<TbCommodityPrice> selectByExample(TbCommodityPriceExample example);

    TbCommodityPrice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCommodityPrice record, @Param("example") TbCommodityPriceExample example);

    int updateByExample(@Param("record") TbCommodityPrice record, @Param("example") TbCommodityPriceExample example);

    int updateByPrimaryKeySelective(TbCommodityPrice record);

    int updateByPrimaryKey(TbCommodityPrice record);
}