package com.gzdsy.gogbee.bee.support.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le0n on 2019/2/13.
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {



        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//                .apis(RequestHandlerSelectors.basePackage("com.gzdsy.gogbee.bee.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("默认-所有")
                .globalOperationParameters(this.getPars());
    }



//    /**
//     * 所有接口
//     * @return
//     */
//    @Bean
//    public Docket webApiAll() {
//        String groupName = "默认-所有";
//        String antPattern = "/*/**";
//        return createDocket(groupName,antPattern);
//    }

    /**
     * 平台管理单元
     * @return
     */
    @Bean
    public Docket webApiPc() {
        String groupName = "平台管理单元-所有";
        String antPattern = "/pc/**";
        return createDocket(groupName,antPattern);
    }

    /**
     * 微信H5商城单元
     * @return
     */
    @Bean
    public Docket webApiMobile() {
        String groupName = "微信H5商城单元-所有";
        String antPattern = "/mobile/**";
        return createDocket(groupName,antPattern);
    }


    /**
     * 统一API信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("美乘网配送系统")
                .description("powered by gogbee")
                .termsOfServiceUrl("http://bee.gogbee.com")
                //.contact(contact)
                .version("1.0")
                .build();
    }

    /**
     *
     * @return
     */
    private List<Parameter> getPars(){
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        ticketPar.name("token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
        return pars;
    }

    private Docket createDocket(String groupName,String antPattern){
//        String groupName = "微信H5商城单元";
//        String antPattern = "/mobile/**";

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant(antPattern))
                .build()
                .groupName(groupName)
                .pathMapping("/")
                .globalOperationParameters(this.getPars());
    }

}