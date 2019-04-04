package com.example.springbootmvc.conf;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava.Range;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 读取应用程序运行 时的 环境变量的类
 */
@Configuration
@ConditionalOnJava(range=Range.EQUAL_OR_NEWER,value=JavaVersion.EIGHT)
public class EnvConfig implements BeanPostProcessor{
	@Autowired private  Environment  env;
	public int getServerPort(){
		System.out.println("获取运行的端口号" + env.getProperty("server.port", Integer.class));
		return env.getProperty("server.port", Integer.class);
	}
}
