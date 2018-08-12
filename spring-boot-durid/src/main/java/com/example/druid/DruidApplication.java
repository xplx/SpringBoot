package com.example.druid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
//mapper包扫描@MapperScan
@MapperScan("com.example.druid.mapper")
@EnableScheduling
public class DruidApplication extends SpringBootServletInitializer {
	/**
	 * 启动类需要添加Servlet的支持
	 * @param application
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DruidApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DruidApplication.class, args);
	}
}
