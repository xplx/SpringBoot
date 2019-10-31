package com.example.seed.service.impl;

import com.example.seed.dao.UserInfoMapper;
import com.example.seed.model.UserInfo;
import com.example.seed.service.UserInfoService;
import com.example.seed.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by wuxiaopeng on 2019/10/30.
 */
@Service
@Transactional
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

}
