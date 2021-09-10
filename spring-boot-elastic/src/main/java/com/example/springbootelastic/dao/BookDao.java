package com.example.springbootelastic.dao;

import com.example.springbootelastic.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDao extends CrudRepository<BookEntity, String> {
	List<BookEntity> getByMessage(String key);
	Page<BookEntity> getByMessage(String key, Pageable pageable);
	@Query("{\"bool\" : {\"must\" : {\"field\" : {\"name\" : \"?0\"}}}}")
    Page<BookEntity> findByName(String name, Pageable pageable);
}
