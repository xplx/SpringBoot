package com.example.springbootcache.service.serviceImpl;

import com.example.springbootcache.bean.Book;
import com.example.springbootcache.service.BookRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-06-19 11:24
 **/
@Service
public class BookRepositoryImpl implements BookRepository {
    /**
     * 在需要缓存的地方加入@Cacheable注解，
     * 比如在getByIsbn（）方法上加入@Cacheable(“books”)，
     * 这个方法就开启了缓存策略，
     * 当缓存有这个数据的时候，会直接返回数据，不会等待去查询数据库。
     * @param isbn
     * @return
     */
    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
