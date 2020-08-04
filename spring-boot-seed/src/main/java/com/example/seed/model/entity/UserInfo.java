package com.example.seed.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.ToString;

@ToString
@ApiModel("")
@Table(name = "user_info")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

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
     * 状态值
     */
    @ApiModelProperty(value = "状态值")
    @Column(name = "status_value")
    private String statusValue;

    /**
     * 状态（0：未退休，1：已退休）
     */
    @ApiModelProperty(value = "状态（0：未退休，1：已退休）", example="0")
    private Integer status;

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

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取名字
     *
     * @return name - 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取状态值
     *
     * @return status_value - 状态值
     */
    public String getStatusValue() {
        return statusValue;
    }

    /**
     * 设置状态值
     *
     * @param statusValue 状态值
     */
    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    /**
     * 获取状态（0：未退休，1：已退休）
     *
     * @return status - 状态（0：未退休，1：已退休）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态（0：未退休，1：已退休）
     *
     * @param status 状态（0：未退休，1：已退休）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取薪资
     *
     * @return salary - 薪资
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * 设置薪资
     *
     * @param salary 薪资
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}