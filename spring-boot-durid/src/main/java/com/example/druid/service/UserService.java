package com.example.druid.service;

import com.example.druid.pojo.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUsersInfo();

    Users getUsersById(int id);

    String saveUsersInfo();

    String updateUsersInfo();

}
