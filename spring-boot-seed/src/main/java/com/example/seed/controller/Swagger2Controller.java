package com.example.seed.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import io.swagger.models.Swagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponents;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.service.Documentation;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.PropertySourcedMapping;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.json.JsonSerializer;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Set;

import static com.google.common.base.Strings.isNullOrEmpty;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static springfox.documentation.swagger.common.HostNameProvider.componentsFrom;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/1/10 14:16
 */
@Controller
@ApiIgnore
public class Swagger2Controller {
    public static final String DEFAULT_URL = "/v2/api-docs/wxp";
    private static final Logger LOGGER = LoggerFactory.getLogger(springfox.documentation.swagger2.web.Swagger2Controller.class);
    private static final String HAL_MEDIA_TYPE = "application/hal+json";

    private final String hostNameOverride;
    private final DocumentationCache documentationCache;
    private final ServiceModelToSwagger2Mapper mapper;
    private final JsonSerializer jsonSerializer;

    @Autowired
    public Swagger2Controller(
            Environment environment,
            DocumentationCache documentationCache,
            ServiceModelToSwagger2Mapper mapper,
            JsonSerializer jsonSerializer) {

        this.hostNameOverride =
                environment.getProperty(
                        "springfox.documentation.swagger.v2.host",
                        "DEFAULT");
        this.documentationCache = documentationCache;
        this.mapper = mapper;
        this.jsonSerializer = jsonSerializer;
    }

    @RequestMapping(
            value = DEFAULT_URL,
            method = RequestMethod.GET,
            produces = { APPLICATION_JSON_VALUE, HAL_MEDIA_TYPE })
    @PropertySourcedMapping(
            value = "${springfox.documentation.swagger.v2.path}",
            propertyKey = "springfox.documentation.swagger.v2.path")
    @ResponseBody
    public ResponseEntity<Json> getDocumentation(
            @RequestParam(value = "group", required = false) String swaggerGroup,
            HttpServletRequest servletRequest) {

        String groupName = Optional.fromNullable(swaggerGroup).or(Docket.DEFAULT_GROUP_NAME);
        Documentation documentation = documentationCache.documentationByGroup(groupName);
        if (documentation == null) {
            LOGGER.warn("Unable to find specification for group {}", groupName);
            return new ResponseEntity<Json>(HttpStatus.NOT_FOUND);
        }
        Swagger swagger = mapper.mapDocumentation(documentation);
        UriComponents uriComponents = componentsFrom(servletRequest, swagger.getBasePath());
        swagger.basePath(Strings.isNullOrEmpty(uriComponents.getPath()) ? "/" : uriComponents.getPath());
        if (isNullOrEmpty(swagger.getHost())) {
            swagger.host(hostName(uriComponents));
        }
        ResponseEntity<Json> responseEntity = new ResponseEntity<Json>(jsonSerializer.toJson(swagger), HttpStatus.OK);
        String bodyJson = responseEntity.getBody().value();
        JSONObject jsonObject = JSONUtil.parseObj(bodyJson);
        Set<String> it = jsonObject.keySet();
        for (String key : it) {
            String value = jsonObject.getStr(key);
//            System.out.println("key：" + key);
//            System.out.println("value: " + value);


            if ("paths".equals(key)) {
                JSONObject jsonPaths = JSONUtil.parseObj(value);
                Set<String> setPaths = jsonPaths.keySet();
                for (String keyPaths : setPaths) {
                    String valuePaths = jsonPaths.getStr(keyPaths);
//                    System.out.println("keyPaths：" + keyPaths);
//                    System.out.println("valuePaths: " + valuePaths);


                    JSONObject jsonDetail = JSONUtil.parseObj(valuePaths);
                    Set<String> setDetail = jsonDetail.keySet();
                    for (String keyDetail : setDetail) {
                        String valueDetail= jsonDetail.getStr(keyDetail);
//                        System.out.println("keyDetail：" + keyDetail);
//                        System.out.println("valueDetail: " + valueDetail);

                        JSONObject jsonParam = JSONUtil.parseObj(valueDetail);
                        Set<String> setParam = jsonParam.keySet();
                        for (String keyParam : setParam) {

                            if ("operationId".equals(keyParam)) {
                                String operationId = jsonParam.getStr(keyParam);
                                System.out.println(operationId);
                            }
                            if ("responses".equals(keyParam)) {
                                String responses = jsonParam.getStr(keyParam);
                                System.out.println("responses:" +responses);

                                JSONObject jsonResponses = JSONUtil.parseObj(responses);
                                Set<String> setResponses = jsonResponses.keySet();
                                for (String keyResponses : setResponses) {

                                }
                            }
                            if ("parameters".equals(keyParam)) {
                                String parameters = jsonParam.getStr(keyParam);
                                System.out.println("parameters:" + parameters);

                                JSONArray jsonParameters = JSONUtil.parseArray(parameters);
                                Iterator<Object> itO = jsonParameters.iterator();
                                for (Object o : jsonParameters) {
                                    System.out.println(o);
                                }

                            }

                        }

                    }
                }
            }
        }

        return responseEntity;
    }

    private String hostName(UriComponents uriComponents) {
        if ("DEFAULT".equals(hostNameOverride)) {
            String host = uriComponents.getHost();
            int port = uriComponents.getPort();
            if (port > -1) {
                return String.format("%s:%d", host, port);
            }
            return host;
        }
        return hostNameOverride;
    }
}
