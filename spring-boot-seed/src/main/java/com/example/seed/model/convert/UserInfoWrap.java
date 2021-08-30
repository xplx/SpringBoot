package com.example.seed.model.convert;

import com.example.seed.model.entity.Shop;
import com.example.seed.model.entity.UserInfo;
import com.example.seed.model.vo.ShopVO;
import com.example.seed.model.vo.UserInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author wxp
 * @2020-10-26
 */
@Mapper
public interface UserInfoWrap {
    UserInfoWrap INSTANCE = Mappers.getMapper(UserInfoWrap.class);

    @Mapping(source = "name", target = "shopName")
    ShopVO toConvertVo(Shop source);

    List<ShopVO> toConvertVoList(List<Shop> source);
}