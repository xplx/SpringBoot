package com.example.springbootcache.service;

import com.example.springbootcache.bean.Book;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-06-19 11:22
 **/
public interface BookRepository {
    /**
     * 获取数据接口
     * @param isbn
     * @return
     */
    Book getByIsbn(String isbn);
}
