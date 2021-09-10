package com.example.springbootelastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.apache.coyote.http11.Http11NioProtocol;

@SpringBootApplication
public class SpringBootElasticApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootElasticApplication.class, args);
	}

	@Bean
	public ConfigurableServletWebServerFactory webServerFactory() {
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.setProtocol("org.apache.coyote.http11.Http11NioProtocol");
//		factory.setProtocol("org.apache.coyote.http11.Http11Nio2Protocol");
//		factory.setProtocol("org.apache.coyote.http11.Http11AprProtocol");
		return factory;
	}
}
