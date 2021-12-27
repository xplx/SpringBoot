package com.example.seed.model.convert;

import com.example.seed.model.entity.Shop;
import com.example.seed.model.entity.ShopDetail;
import com.example.seed.model.vo.ShopVO;
import com.sun.syndication.feed.atom.Person;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * * @author wxp
 *
 * @2020-10-26
 */
//声明它是一个 MapStruct Mapper 映射器。
@Mapper
public interface ShopConvert {
    ShopConvert INSTANCE = Mappers.getMapper(ShopConvert.class);


    @ToEntity
    @Mappings({
            @Mapping(source = "name", target = "shopName"),
            @Mapping(source = "id", target = "shopId"),
            @Mapping(source = "age", target = "age")
    })
    ShopVO toConvertVo(Shop source);

    //默认行为将是明确的映射,这意味着所有映射必须通过的方式来指定@Mapping
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "source.name", target = "shopName"),
            @Mapping(source = "detail.address", target = "address")
    })
    ShopVO toConvertMoreVo(ShopDetail detail, Shop source);

    List<ShopVO> toConvertVoList(List<Shop> source);
}