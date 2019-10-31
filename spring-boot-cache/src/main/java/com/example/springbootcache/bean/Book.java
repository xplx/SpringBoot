package com.example.springbootcache.bean;

import lombok.Data;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-06-19 11:21
 **/
@Data
public class Book {
    private String isbn;
    private String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }
}
