package com.example.seed.model.vo;

import com.example.seed.model.constant.StatusValueEnum;
import com.example.seed.model.constant.UserInfoStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserInfoVo {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @NotNull(message="主键id不能为空")
    @Id
    private Long id;

    /**
     * 名字
     */
    @ApiModelProperty(value = "名字")
    @NotEmpty(message="名字不能为空")
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 状态（0：未退休，1：已退休）
     */
    @ApiModelProperty(value = "状态（0：未退休，1：已退休）", example="0")
    private UserInfoStatusEnum status;

    /**
     * 状态（0：未退休，1：已退休）
     */
    @ApiModelProperty(value = "状态（0：未退休，1：已退休）", example="0")
    private StatusValueEnum statusValue;

    /**
     * 薪资
     */
    @ApiModelProperty(value = "薪资", example="0.00")
    private BigDecimal salary;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;
}