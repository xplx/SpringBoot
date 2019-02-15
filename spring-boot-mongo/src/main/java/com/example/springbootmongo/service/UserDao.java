package com.example.springbootmongo.service;

import com.example.springbootmongo.entity.UserEntity;
import org.springframework.stereotype.Service;

public interface UserDao {
    /**
     * 创建对象
     * @param user
     */
    void saveUser(UserEntity user);

    /**
     * 根据用户名查询对象
     * @param userName
     * @return
     */
    UserEntity findUserByPassWord(String userName);

    /**
     * 更新对象
     * @param user
     */
    void updateUser(UserEntity user);

    /**
     * 删除对象
     * @param id
     */
    void deleteUserById(Long id);
}
