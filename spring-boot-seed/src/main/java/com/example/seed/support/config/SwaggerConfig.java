package com.example.seed.support.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Le0n
 * @date 2019/09/3
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 所有接口
     *
     * @return
     */
    @Bean
    public Docket webApiAll() {
        String groupName = "default";
        String antPattern = "/*/**";
        return createDocket(groupName, antPattern);
    }


    /**
     * 统一API信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API 文档")
                .description("文档地址： /doc.html 或 /swagger-ui.html")
                .termsOfServiceUrl("http://www.xxxxx.com")
                .contact(new Contact("wuxiaopeng", "", ""))
                .version("1.0.0")
                .build();
    }

    /**
     * @return
     */
    private List<Parameter> getPars() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        //header中的ticket参数非必填，传空也可以
        ticketPar.name("Authorization").description("令牌").
                modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        //根据每个方法名也知道当前方法在设置什么参数
        pars.add(ticketPar.build());
        return pars;
    }

    private Docket createDocket(String groupName, String antPattern) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant(antPattern))
                .build()
                .groupName(groupName)
                .pathMapping("/")
//                .globalOperationParameters(this.getPars())
                ;
    }
}
