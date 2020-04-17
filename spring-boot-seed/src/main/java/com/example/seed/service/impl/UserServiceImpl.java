package com.example.seed.service.impl;

import com.example.seed.mapper.UserMapper;
import com.example.seed.model.entity.User;
import com.example.seed.service.UserService;
import tk.mybatis.template.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;


/**
*
* @author wuxiaopeng
* @date 2020/03/26
*/
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
