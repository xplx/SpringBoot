package com.example.springbootmvc.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.example.springbootmvc.dao.UserRepository;
import com.example.springbootmvc.entity.Department;
import com.example.springbootmvc.entity.User;
import com.example.springbootmvc.service.CreditSystemService;
import com.example.springbootmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userDao;
	
	@Autowired
	EntityManager em;

	@Autowired
	CreditSystemService creditSystemService;
	public void updateUser(User user){
		userDao.save(user);
	}
	
	public User findUser(int id) {
		Optional<User> user = userDao.findById(id);
		return user.orElse(null);
	}
	
	public Integer addUser(User user){
		//插入语句
		userDao.save(user);
		user.setName("1"+user.getName());
		//当插入的语句存在时，更新语句
		userDao.save(user);
		//返回插入的id
		return user.getId();
	}

	public List<User> getAllUser(int page,int size) {
		PageRequest pageable = PageRequest.of(page, size);
		//返回实体列表
		Page<User> pageObject =  userDao.findAll(pageable);
		//总的页数
		int totalPage = pageObject.getTotalPages();
		//实际返回数
		int realSize = pageObject.getSize();
		//返回总数
		long count = pageObject.getTotalElements();
		//返回此次查询
		return pageObject.getContent();
	}

	public User getUser(String name) {
		
		return userDao.findByName(name);
	}
	
	public User getUser(String name,Integer departmentId) {
//		getUser(departmentId);
		return userDao.nativeQuery2(name, departmentId);
//		return userDao.findUserByDepartment(name, departmentId);
	}
	
	private void getUser(Integer departmentId){
		List<Object[]> list = userDao.queryUserCount();
		List<Integer> ids = userDao.queryUserIds(departmentId);
		int a = 1;
	}
	
	public Page<User> queryUser(Integer departmentId,Pageable page){
		return userDao.queryUsers(departmentId, page);
	}
	
	public Page<User> queryUser2(Integer departmentId,Pageable page){
		//构造JPQL和实际的参数
		StringBuilder baseJpql = new StringBuilder("from User u where 1=1 ");
		Map<String,Object> paras = new HashMap<String,Object>();
		if(departmentId!=null){
			baseJpql.append("and  u.department.id=:deptId");
			paras.put("deptId", departmentId);
		}
		//查询满足条件的总数
		long count = getQueryCount(baseJpql,paras);
		if(count==0){
			return new PageImpl(Collections.emptyList(),page,0);
		}
		//查询满足条件结果集
		List list = getQueryResult(baseJpql,paras,page);
		
	
		
		//返回结果
		Page ret = new PageImpl(list,page,count);
		return ret;
	}
	
	public List<User> getByExample(String name) {
		User user = new User();
		Department dept = new Department();
		user.setName(name);
		dept.setId(1);
		user.setDepartment(dept);
		ExampleMatcher matcher = ExampleMatcher.matching()
				  .withMatcher("name", GenericPropertyMatchers.startsWith().ignoreCase());
		Example<User> example = Example.of(user, matcher);
//		Example<User> example = Example.of(user);
		List<User> list = userDao.findAll(example);
		return list;
	}
	
	private List getQueryResult(StringBuilder baseJpql,Map<String,Object> paras,Pageable page){
		Query query= em.createQuery("select u "+baseJpql.toString());
		setQueryParameter(query,paras);
		query.setFirstResult((int)page.getOffset());
		query.setMaxResults(page.getPageNumber());
		List list = query.getResultList();
		return list;
	}
	private Long getQueryCount(StringBuilder baseJpql,Map<String,Object> paras){
		Query query= em.createQuery("select count(1) "+baseJpql.toString());
		setQueryParameter(query,paras);
		Number number = (Number)query.getSingleResult();
		return number.longValue();
	}
	private void setQueryParameter(Query query,Map<String,Object> paras ){
		for(Entry<String,Object> entry:paras.entrySet()){
			query.setParameter(entry.getKey(),entry.getValue());
		}
	}

	@Override
	public int getCredit(int userId) {
		return creditSystemService.getUserCredit(userId);

	}
}
