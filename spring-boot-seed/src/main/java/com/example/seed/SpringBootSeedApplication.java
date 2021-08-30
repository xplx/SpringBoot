package com.example.seed;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.example.seed.support.utils.MyConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import tk.mybatis.spring.annotation.MapperScan;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wuxiaopeng
 * @date 2020-01-18
 * @ComponentScan :默认Spring框架实现会从声明@ComponentScan所在类的package进行扫描。
 * @EnableAutoConfiguration:
 */
@EnableFeignClients
@EnableCaching
@MapperScan(basePackages = {"com.example.seed.mapper","tk.mybatis.template.core.Mapper"})
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@Slf4j
public class SpringBootSeedApplication {

    public static void main(String[] args) throws UnknownHostException {
        //SpringApplication.run(SpringBootSeedApplication.class, args);
//        SpringApplication application = new SpringApplication(SpringBootSeedApplication.class);
//        application.run(args);
        ConfigurableApplicationContext application = SpringApplication.run(SpringBootSeedApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = MyConvertUtils.getString(env.getProperty("server.servlet.context-path"));
        log.info("\n----------------------------------------------------------\n\t" +
                "Application Jeecg-Boot is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "Swagger文档: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "----------------------------------------------------------");
    }
}
