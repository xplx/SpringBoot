package com.example.seed.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaopeng
 * @date 2021年03月25日 14:18
 * @description
 */
@Configuration
public class BeanInitOrderConfig {
    @Bean(initMethod = "initMethod" ,destroyMethod = "destroyMethod")
    public BeanInitOrder getBeanInitOrder(){
        return new BeanInitOrder();
    }

    @Bean
    public InitBeanHandleBeanPostProcessor getInitBeanHandle(){
        return new InitBeanHandleBeanPostProcessor();
    }

    @Bean
    public static InitBeanHandleBeanFactoryPostProcessor getInitBeanHandleBeanFactoryPostProcessor(){
        return new InitBeanHandleBeanFactoryPostProcessor();
    }
}
