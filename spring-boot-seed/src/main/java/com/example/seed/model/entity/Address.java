package com.example.seed.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel("地址信息")
@Table(name = "address")
@Data
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @NotNull(message="主键id不能为空")
    @TableId(type = IdType.ASSIGN_ID)
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
    @ApiModelProperty(value = "性别")
    private Integer sex;
    /**
     * 密码
     */
    @ApiModelProperty(value = "地址")
    private String address;
}
