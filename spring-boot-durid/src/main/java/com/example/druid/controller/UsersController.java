package com.example.druid.controller;

import com.example.druid.pojo.Users;
import com.example.druid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;
    @RequestMapping("/getAllUsers")
    public List<Users> getAllUsers(){
        List<Users> usersList = userService.getAllUsersInfo();
        return usersList;
    }

    @RequestMapping("/getUsers")
    public Users getUsers(int id){
        Users users= userService.getUsersById(id);
        return users;
    }

    @RequestMapping("/save")
    public String saveUsers(){
        String result = userService.saveUsersInfo();
        return result;
    }

    @RequestMapping("/update")
    public String updateUsers(){
        String result = userService.updateUsersInfo();
        return result;
    }
}
