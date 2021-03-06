package com.example.springbootjwt.support.filter;


import com.example.springbootjwt.util.EmptyUtil;
import io.swagger.models.parameters.HeaderParameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author Le0n
 * @date 2019/09/3
 */
@Component
@Slf4j
@ConditionalOnProperty(name = "spring.profiles.active")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest myServletRequest = servletRequest;
        HttpServletRequest hrequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
    }
    @Override
    public void destroy() {
        log.info(">>>>>> Filter Destroy");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(">>>>>> Filter Init");
    }
}
