package com.example.springbootcache.service;


import com.example.springbootcache.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {

    ServerResponse createToken();

    void checkToken(HttpServletRequest request);

}
