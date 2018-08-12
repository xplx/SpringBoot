package com.example.druid.service.serviceImpl;

import com.example.druid.mapper.UsersMapper;
import com.example.druid.pojo.Users;
import com.example.druid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public List<Users> getAllUsersInfo(){
        List<Users> usersList = usersMapper.selectAll();
        return usersList;
    }

    @Override
    public Users getUsersById(int id){
        Users u = new Users();
        u.setId(id);
        Users users = usersMapper.selectOne(u);
        return users;
    }

    @Override
    public String saveUsersInfo(){
        Users u = new Users();
        u.setUsername("杨志");
        u.setPassword("123456");
        u.setUserSex("1");
        u.setNickName("hello");
        int result = usersMapper.insert(u);
        return "save success";
    }

    @Override
    public String updateUsersInfo(){
        Users u = new Users();
        u.setId(28);
        u.setUsername("update");
        u.setNickName("update");
        u.setUserSex("2");
        u.setPassword("123456789");
        try {
            int result = usersMapper.updateByPrimaryKey(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "updata success";
    }
}
