package com.example.seed.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.seed.support.utils.BeanUtil;
import com.example.seed.support.utils.EmptyUtil;
import com.example.seed.support.utils.RedisUtil;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import io.swagger.models.Model;
import io.swagger.models.Operation;
import io.swagger.models.Path;
import io.swagger.models.Swagger;
import io.swagger.models.parameters.Parameter;
import io.swagger.models.parameters.QueryParameter;
import io.swagger.models.properties.Property;
import org.apache.commons.lang3.StringUtils;
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
import java.util.List;
import java.util.Map;
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
    private RedisUtil redisUtil;

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
            produces = {APPLICATION_JSON_VALUE, HAL_MEDIA_TYPE})
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
        //获取swagger路径返回参数
        Map<String, Model> returnModelMap = swagger.getDefinitions();
        Iterator<Map.Entry<String, Model>> returnModelSet = returnModelMap.entrySet().iterator();
        while (returnModelSet.hasNext()) {
            String redisParam = redisUtil.get("param/") + "";
            //获取路径参数
            Map.Entry<String, Model> modeMap = returnModelSet.next();
            String returnType = modeMap.getKey().substring(0, 3);
            System.out.println(returnType);
            if (!"返回类".equals(returnType)) {
                Model modelValue = modeMap.getValue();

                Map<String, Property> mapProperties = modelValue.getProperties();
                Iterator<Map.Entry<String, Property>> iteratorProperties = mapProperties.entrySet().iterator();
                while (iteratorProperties.hasNext()) {
                    Map.Entry<String, Property> propertyMap = iteratorProperties.next();
                    Property property = propertyMap.getValue();
                    property.setExample("1000");
                }
            }
        }


        //获取swagger路径参数
        Map<String, Path> pathsMap = swagger.getPaths();
        Iterator<Map.Entry<String, Path>> pathsIterator = pathsMap.entrySet().iterator();
        while (pathsIterator.hasNext()) {

            //获取路径参数
            Map.Entry<String, Path> pathMap = pathsIterator.next();
            Path path = pathMap.getValue();
            String pathUrl = pathMap.getKey();
            String redisParam = redisUtil.get("param/" + pathUrl) + "";

            //获取入参示例
            JSONObject redisParamJson = JSONObject.parseObject(redisParam);
            Operation pathOperation = path.getGet();
            /***********查询参数初始化***************/
            if (EmptyUtil.isNotEmpty(pathOperation) && EmptyUtil.isNotEmpty(redisParamJson)) {
                List<Parameter> parameterList = pathOperation.getParameters();
                List<QueryParameter> parameterVOList = BeanUtil.toModelList(parameterList, QueryParameter.class);
                parameterList.clear();
                for (QueryParameter queryParameter : parameterVOList) {
                    String exampleValue = redisParamJson.getString(queryParameter.getName());
                    if (StringUtils.isNotBlank(exampleValue)) {
                        queryParameter.setExample(exampleValue);
                    }
                    parameterList.add(queryParameter);
                }
            }
        }

        ResponseEntity<Json> responseEntity = new ResponseEntity<Json>(jsonSerializer.toJson(swagger), HttpStatus.OK);
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
