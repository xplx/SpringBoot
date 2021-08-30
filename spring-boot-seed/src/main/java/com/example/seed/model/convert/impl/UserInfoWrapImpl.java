package com.example.seed.model.convert.impl;

import com.example.seed.model.convert.UserInfoWrap;
import com.example.seed.model.entity.Shop;
import com.example.seed.model.vo.ShopVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author wxp
 * @2020-10-26
 */
public class UserInfoWrapImpl implements UserInfoWrap {
    public UserInfoWrapImpl() {

    }

    @Override
    public ShopVO toConvertVo(Shop source) {
        ShopVO shopVO = new ShopVO();
        shopVO.setId(0);
        shopVO.setShopName("默认值");
        return shopVO;
    }

    @Override
    public List<ShopVO> toConvertVoList(List<Shop> source) {
        return null;
    }
}