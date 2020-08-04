package com.example.seed.support.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/4/24 10:45
 */
@Configuration
public class DruidConfiguration {
    /**
     * http://localhost:8888/druid/index.html
     * Druid内置提供了一个StatViewServlet用于展示Druid的统计信息
     *
     * @return servlet registration bean
     */
    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new StatViewServlet(), "/druid/*");
        //配置
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        //是否允许清空统计数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        //允许访问敏感信息
        servletRegistrationBean.addInitParameter("allow", "128.242.127.1,10.10.11.64");
        //不允许访问敏感信息
        servletRegistrationBean.addInitParameter("deny", "10.10.11.65");
        return servletRegistrationBean;
    }


    /**
     * 注册一个：filterRegistrationBean
     *
     * @return filter registration bean
     */
    @Bean
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(
                new WebStatFilter());
        // 添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        // 添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}

