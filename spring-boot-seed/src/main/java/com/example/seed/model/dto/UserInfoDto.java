package com.example.seed.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.template.annotation.ParamCondition;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Data
public class UserInfoDto {
    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull
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
    private Integer age;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @ParamCondition(pattern = "=")
    private String password;
}