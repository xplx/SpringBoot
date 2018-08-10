package com.example.springbootmvc.db;


import com.example.springbootmvc.dao.UserDao;
import com.example.springbootmvc.entity.User;
import com.example.springbootmvc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
//Spring Boot 单元测试默认会在单元测试方法运行结束后进行事务回滚
@Transactional
public class UserDbTest {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;
	
	@Test
	//@Sql({"classpath:com/example/springbootmvc/db/user.sql"}) //初始化一条主键为1的用户数据
	public void upateNameTest(){
		User user = new User();
		user.setId(4);
		user.setName("hello123");
		int flag = userDao.updateById(user);
		User dbUser = userDao.unique(4);
		System.out.println(dbUser.getName());
	}
}
