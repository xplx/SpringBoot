package com.example.springbootmvc.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 将一组同样类型的配置属性映射为一个类更为方便，比如服务器配置.
 */
@ConfigurationProperties("server")	
@Configuration
public class ServerConfig {
	private int port;
	private  Servlet servlet = new Servlet();
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
    public Servlet getServlet() {
		return servlet;
	}
	public void setServlet(Servlet servlet) {
		this.servlet = servlet;
	}

	public static  class Servlet{
    			String path ;

			public String getPath() {
				return path;
			}

			public void setPath(String path) {
				this.path = path;
			}
    		
    }
}
