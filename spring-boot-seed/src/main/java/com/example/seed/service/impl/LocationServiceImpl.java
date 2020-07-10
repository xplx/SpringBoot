package com.example.seed.service.impl;

import com.example.seed.mapper.LocationMapper;
import com.example.seed.model.entity.Location;
import com.example.seed.model.entity.User;
import com.example.seed.service.LocationService;
import com.example.seed.service.UserService;
import org.springframework.transaction.annotation.Propagation;
import tk.mybatis.template.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


/**
 * @author wuxiaopeng
 * @date 2020/06/11
 */
@Service
@Transactional
public class LocationServiceImpl extends AbstractService<Location> implements LocationService {
    @Resource
    private LocationMapper locationMapper;
    @Resource
    private UserService userService;

    /**
     * PROPAGATION_REQUIRED(默认实现)：当前没有事务则新建事务，有则加入当前事务
     *
     * @param location
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public void saveLocation(Location location) {
        locationMapper.insertSelective(location);
    }

    @Override
    public void saveLocationException(Location location) {
        locationMapper.insertSelective(location);
        throw new RuntimeException("保存用户信息异常");
    }

    @Override
    public void saveLocationPropagation() {
        User user = new User();
        user.setName("测试使用");
        user.setAge(0);
        user.setEmail("1099@qq.com");
        user.setCreateDate(new Date());
        userService.saveUser(user);

        Location location = new Location();
        location.setName("测试测试");
        //异常抓取，事物没有回滚
        saveLocationException(location);
        //外围方法异常不影响内部插入，方法独立的事务。
        throw new RuntimeException("外围异常！");
    }
}
