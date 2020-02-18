package com.example.seed.model.dto;

import com.example.seed.support.param.MapperParamCondition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Transient;

@Data
public class UserInfoDto {
    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @MapperParamCondition(pattern = "in",entityName = "id")
    private Long[] ids;

    /**
     * 名字
     */
    @ApiModelProperty(value = "名字", example = "5000")
    @MapperParamCondition(pattern = "like",fuzzyPosition = "all")
    @Transient
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    @MapperParamCondition(pattern = ">=")
    private Integer age;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @MapperParamCondition(pattern = "=")
    private String password;
}