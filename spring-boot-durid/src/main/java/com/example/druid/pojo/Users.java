package com.example.druid.pojo;

import java.util.Date;
import javax.persistence.*;

public class Users {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "userName")
    private String username;

    /**
     * 密码
     */
    @Column(name = "passWord")
    private String password;

    @Column(name = "user_sex")
    private String userSex;

    @Column(name = "nick_name")
    private String nickName;

    private Integer age;

    private Date birthday;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return userName - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return passWord - 密码
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
     * @return user_sex
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * @param userSex
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}