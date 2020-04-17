package com.example.seed.service.impl;

import com.example.seed.mapper.UserInfoMapper;
import com.example.seed.model.entity.UserInfo;
import com.example.seed.model.vo.UserInfoVo;
import com.example.seed.service.UserInfoService;
import org.springframework.stereotype.Service;
import tk.mybatis.template.core.AbstractService;

import javax.annotation.Resource;
import java.util.List;


/**
*
* @author wuxiaopeng
* @date 2020/03/04
*/
@Service
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfoVo> selectAllUserInfoList(UserInfo userInfo) {
        return userInfoMapper.selectAllUserInfoList(userInfo);
    }

    @Override
    public void deleteInfo(Integer[] ids) {
        this.deleteById(ids[0]);
        int a = 1 / 0;
    }
}
