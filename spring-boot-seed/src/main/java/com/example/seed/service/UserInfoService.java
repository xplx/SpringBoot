package com.example.seed.service;

import com.example.seed.model.entity.UserInfo;
import com.example.seed.model.vo.UserInfoVo;
import tk.mybatis.template.core.Service;

import java.util.List;


/**
*
* @author wuxiaopeng
* @date 2020/03/04
*/
public interface UserInfoService extends Service<UserInfo> {
    /**
     * 获取所有信息
     * @return
     */
    List<UserInfoVo> selectAllUserInfoList(UserInfo userInfo);
    /**
     * 删除信息
     */
    void deleteInfo(Integer[] ids);
}
