package com.example.springbootmvc.controller;

import java.util.List;

import com.example.springbootmvc.entity.User;
import com.example.springbootmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping("/findTest.html")
	public @ResponseBody int getUser(int userId){
		System.out.println("test2");
		return userId;
	}
	@RequestMapping("/finduser.html")
	public @ResponseBody String findUser(int userId){
		User user =  userService.findUser(userId);

		return user.getName();
	}
	@RequestMapping("/adduser.html")
	public @ResponseBody String addUser(User user){
		int id =   userService.addUser(user);
		return String.valueOf(id);
	}

	/**
	 * 分页查询，其中page从第0页开始
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/alluser.html")
	public @ResponseBody String alluser(int page,int size){
		List<User> list =  userService.getAllUser(page,size);
		return String.valueOf(list.size());
	}

	/**
	 *
	 * @param name
	 * @return
	 */
	@RequestMapping("/getuser.html")
	public @ResponseBody String getUser(String name){
		User user=  userService.getUser(name);
		return String.valueOf(user.getName());
	}
	
	@RequestMapping("/getdepartuser.html")
	public @ResponseBody String getDepartmentUser(String name,Integer deptId){
		User user=  userService.getUser(name, deptId);
		return user==null?"":String.valueOf(user.getName());
	}
	
	@RequestMapping("/pagequery.html")
	public @ResponseBody String pageQuery(Integer deptId,int page,int size){
		PageRequest pr = new PageRequest(page,size);
//		Page<User> users =  userService.queryUser(deptId, pr);
		Page<User> users =  userService.queryUser2(deptId, pr);
		return String.valueOf(users.getTotalElements());
	}
	
	@RequestMapping("/example.html")
	public @ResponseBody String example(String name){
		List<User> users = userService.getByExample(name);
		return String.valueOf(users.size());
	}

	@RequestMapping("/user/{id}")
	public @ResponseBody String getUser(@PathVariable Integer id){
		return String.valueOf(userService.getCredit(id));
	}

	@RequestMapping("/user/{id}/{name}")
	public @ResponseBody String updateUser(@PathVariable Integer id,@PathVariable String name){
		User user = new User();
		user.setId(id);
		user.setName(name);
		userService.updateUser(user);
		return "{\"success\":true}";
	}
}
