package com.example.seed.model.dto;

import com.example.seed.support.param.ParamCondition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Transient;

@Data
public class UserInfoDto {
    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @ParamCondition(pattern = "in",entityName = "id")
    private Long id;

    /**
     * 主键id
     */
    @ApiModelProperty("主键ids")
    @ParamCondition(pattern = "in",entityName = "id")
    private Long[] ids;

    /**
     * 名字
     */
    @ApiModelProperty(value = "名字", example = "5000")
    @ParamCondition(pattern = "like",fuzzyPosition = "all")
    @Transient
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    @ParamCondition(pattern = ">=")
    private Integer age;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @ParamCondition(pattern = "=")
    private String password;
}