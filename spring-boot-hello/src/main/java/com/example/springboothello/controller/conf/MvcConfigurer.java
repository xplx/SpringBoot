package com.example.springboothello.controller.conf;

import com.example.springboothello.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

	/**
	 * 拦截器
	 * @param registry
	 */
	public void addInterceptors(InterceptorRegistry registry) {
		//试用拦截器拦截指定的URL
		registry.addInterceptor(new SessionHandlerInterceptor()).addPathPatterns("/user/**");
	}

	/**
	 * 跨越访问配置
	 * @param registry
	 */
	public void addCorsMappings(CorsRegistry registry) {
	}

	/**
	 * 格式化
	 * @param registry
	 */
	public void addFormatters(FormatterRegistry registry) {
		 registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
		
	}


	/**
	 * URL到视图的访问
	 * @param registry
	 */
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index.html").setViewName("/index.btl");
		registry.addRedirectViewController("/**/*.do", "/index.html");
	}
	
	/**
	 * 
	 * 检查用户是否已经登录，如果未登录，重定向到登录页面
	 *
	 */
	class SessionHandlerInterceptor implements HandlerInterceptor{
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			String user =  request.getSession().getAttribute("name") + "";
			if(user==null){
				response.sendRedirect("/login.html");
				return false;
			}
				return true;
		}
	}
	
	

}
