package com.example.springbootjwt.util.jwt;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ace on 2017/9/10.
 */
public interface IJWTInfo {
    /**
     * 获取用户名
     * @return
     */
    @ApiModelProperty("用户名称")
    String getUniqueName();

    /**
     * 获取用户ID
     * @return
     */
    @ApiModelProperty("用户id")
    String getId();

    /**
     * 获取名称
     * @return
     */
    @ApiModelProperty("用户名")
    String getName();
}
