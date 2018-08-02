package com.example.springboothello.service.impl;


import com.example.springboothello.entity.User;
import com.example.springboothello.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	public List<User> allUser() {
		return sampleUser(5);
	}
	
	

	public User getUserById(Long id) {
		User user = sampleUser(1).get(0);
		user.setId(id);
		return user;
	}

	
	private List<User> sampleUser(int num){
		List<User> list = new ArrayList<User>(num);
		for(int i=0;i<num;i++){
			User user = new User();
			user.setId((long)i);
			user.setName("mame"+i);
			list.add(user);
		}
		return list;
	}


	public void updateUser(Long id, Integer type) {
		// TODO Auto-generated method stub
		
	}
}
