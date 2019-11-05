package com.example.seed.mapper;

import com.example.seed.model.entity.UserInfo;
import com.example.seed.support.core.Mapper;

import java.util.List;

public interface UserInfoMapper extends Mapper<UserInfo> {
    /**
     * 获取信息
     * @return
     */
    List<UserInfo> getList();
}