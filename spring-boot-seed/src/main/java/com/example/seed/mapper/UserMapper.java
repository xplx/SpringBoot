package com.example.seed.mapper;

import com.example.seed.model.dto.UserInfoSaveUpdateDto;
import com.example.seed.model.entity.User;
import tk.mybatis.template.core.Mapper;

public interface UserMapper extends Mapper<User> {
    void updateUserInfoByKey(UserInfoSaveUpdateDto userInfo);
}