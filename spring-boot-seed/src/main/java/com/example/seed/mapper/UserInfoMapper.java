package com.example.seed.mapper;

import com.example.seed.model.entity.UserInfo;
import com.example.seed.model.vo.UserInfoVo;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.template.core.Mapper;

import java.util.List;

/**
 * 开启二级缓存，更新或者删除时二级缓存失效
 */
@CacheNamespace
public interface UserInfoMapper extends Mapper<UserInfo> {

    /**
     * 获取所有信息
     * @return
     */
    List<UserInfoVo> selectAllUserInfoList(UserInfo userInfo);
}