package com.example.seed.support.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @author Leon
 * @date 2019/09/3
 */
@Component
@Slf4j
public class MyRequestListenter implements ServletRequestListener {


    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
    }
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
    }

}
