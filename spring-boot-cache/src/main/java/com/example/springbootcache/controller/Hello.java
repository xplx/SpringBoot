package com.example.springbootcache.controller;

import com.example.springbootcache.annotation.ApiIdempotent;
import com.example.springbootcache.bean.Book;
import com.example.springbootcache.common.ServerResponse;
import com.example.springbootcache.service.BookRepository;
import com.example.springbootcache.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-06-19 11:43
 **/
@Slf4j
@RestController
public class Hello {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/getMessages")
    public String getMessages() {
        log.info(".... Fetching books");
        log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        log.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        log.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        return "success";
    }

    @ApiIdempotent
    @GetMapping("/getBooks")
    public String getBooks() {
        log.info(".... Fetching books");
        //bookRepository.getByIsbn("isbn-1234");
        return "success";
    }

    @GetMapping("/createToken")
    public ServerResponse token() {
        return tokenService.createToken();
    }
}
