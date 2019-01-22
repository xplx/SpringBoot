package com.example.https;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

/**
 * @author :wuxiaopeng
 * @date :2019-01-22
 */
@SpringBootApplication
public class HttpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpsApplication.class, args);
	}
}

