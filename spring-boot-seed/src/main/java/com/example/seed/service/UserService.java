package com.example.seed.service;
import com.example.seed.model.entity.User;
import tk.mybatis.template.core.Service;


/**
*
* @author wuxiaopeng
* @date 2020/03/26
*/
public interface UserService extends Service<User> {
    /**
     * 保存用户信息
     * @param user
     */
    void saveUser(User user);

    /**
     * 开启新事物
     * @param user
     */
    void saveUserNew(User user);
}
