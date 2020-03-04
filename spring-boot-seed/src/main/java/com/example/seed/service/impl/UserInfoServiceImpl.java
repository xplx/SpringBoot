package com.example.seed.service.impl;

import com.example.seed.mapper.UserInfoMapper;
import com.example.seed.model.entity.UserInfo;
import com.example.seed.service.UserInfoService;
import com.example.seed.support.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
*
* @author wuxiaopeng
* @date 2020/03/04
*/
@Service
@Transactional
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

}
