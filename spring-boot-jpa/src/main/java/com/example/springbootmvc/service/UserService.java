package com.example.springbootmvc.service;

import java.util.List;

import com.example.springbootmvc.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
	public User findUser(int id);
	public Integer addUser(User user);
	public List<User> getAllUser(int start, int end);
	public User getUser(String name);
	public User getUser(String name, Integer departmentId);
	public Page<User> queryUser(Integer departmentId, Pageable page);
	public Page<User> queryUser2(Integer departmentId, Pageable page);
	public List<User> getByExample(String name) ;
	public void updateUser(User user);
	public int getCredit(int userId);
}
