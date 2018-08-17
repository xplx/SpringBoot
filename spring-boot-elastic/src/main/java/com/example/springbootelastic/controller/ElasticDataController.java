package com.example.springbootelastic.controller;


import com.example.springbootelastic.dao.BookDao;
import com.example.springbootelastic.entity.Book;
import com.example.springbootelastic.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ElasticDataController {

	@Autowired
	BookDao dao;

	
	@RequestMapping("/springdata/book/{id}")
	public BookEntity getLogById(@PathVariable String id)  {
		//测试内置的 findByid
		Optional<BookEntity> opt = dao.findById(id);
		BookEntity book = opt.get();
		return book;
	}
	
	@RequestMapping("/springdata/search/{key}")
	public List<BookEntity> search(@PathVariable String key)  {
		//测试全文搜索
		List<BookEntity> list = dao.getByMessage(key);
		return list;
	}

	@RequestMapping("/springdata/save")
	public String save(){
		BookEntity book = new BookEntity();
		book.setId("2");
		book.setMessage("多彩贵州");
		book.setName("贵州");
		book.setType("address");
		book.setPostDate(new Date());
		dao.save(book);
		return "success";
	}

	@RequestMapping("/springdata/delete/{id}")
	public String delete(@PathVariable String id) {
		try {
			dao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "delete success";
	}

	@RequestMapping("/springdata/update")
	public String update(){
		BookEntity book = new BookEntity();
		//主键
		book.setId("2");
		book.setMessage("贵州美好河山");
		book.setName("贵州");
		book.setType("address");
		book.setPostDate(new Date());
		dao.save(book);
		return "success";
	}
	
	@RequestMapping("/springdata/search/{key}/{page}")
	public List<BookEntity>  search(@PathVariable int page, @PathVariable String key)  {
		//测试翻页操作
		int numberOfPage = 5;
		PageRequest request  = PageRequest.of(page, numberOfPage);
		Page<BookEntity> pages = dao.getByMessage(key,request);
		long total = pages.getTotalElements();
		long totalPage = pages.getTotalPages();
		List<BookEntity> list = pages.getContent();
		return list;
	}
	
	
	
}
