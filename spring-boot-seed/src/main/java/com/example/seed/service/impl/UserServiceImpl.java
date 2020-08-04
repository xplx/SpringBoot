package com.example.seed.service.impl;

import com.example.seed.mapper.UserMapper;
import com.example.seed.model.entity.User;
import com.example.seed.service.UserService;
import org.springframework.transaction.annotation.Propagation;
import tk.mybatis.template.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author wuxiaopeng
 * @date 2020/03/26
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void saveUser(User user) {
        this.saveSelectiveId(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void saveUserNew(User user) {
        this.saveSelectiveId(user);
    }
}
