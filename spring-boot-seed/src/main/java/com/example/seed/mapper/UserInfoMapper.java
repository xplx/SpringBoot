package com.example.seed.mapper;

import com.example.seed.model.entity.UserInfo;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.template.core.Mapper;

/**
 * 开启二级缓存，更新或者删除时二级缓存失效
 */
@CacheNamespace
public interface UserInfoMapper extends Mapper<UserInfo> {
}