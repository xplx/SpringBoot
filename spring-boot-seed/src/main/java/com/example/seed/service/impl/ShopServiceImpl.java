package com.example.seed.service.impl;

import com.example.seed.mapper.ShopMapper;
import com.example.seed.model.entity.Shop;
import com.example.seed.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.template.core.AbstractService;

import javax.annotation.Resource;


/**
*
* @author wuxiaopeng
* @date 2019/10/31
*/
@Service
@Transactional
public class ShopServiceImpl extends AbstractService<Shop> implements ShopService {
    @Resource
    private ShopMapper shopMapper;

}
