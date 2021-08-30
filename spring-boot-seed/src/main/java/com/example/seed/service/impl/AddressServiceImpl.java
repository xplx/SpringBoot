package com.example.seed.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seed.mapper.AddressMapper;
import com.example.seed.mapper.UserInfoMapper;
import com.example.seed.model.entity.Address;
import com.example.seed.model.entity.UserInfo;
import com.example.seed.model.vo.UserInfoVo;
import com.example.seed.service.AddressService;
import com.example.seed.service.UserInfoService;
import org.springframework.stereotype.Service;
import tk.mybatis.template.core.AbstractService;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author wuxiaopeng
 * @date 2020/03/04
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
    @Resource
    private UserInfoMapper userInfoMapper;

}
