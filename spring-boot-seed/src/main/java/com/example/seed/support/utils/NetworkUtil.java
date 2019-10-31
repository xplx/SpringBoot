package com.example.seed.support.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Leon
 * @date 2019/09/3
 */
@Slf4j
public class NetworkUtil {

    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static String getSignatureCode(HttpServletRequest request){
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            log.info(key+ ":" +value);
        }
        return null;
    }

    /**
     * 获取 HttpServletRequest Header信息
     * @param request
     * @return
     */
    public static Map<String,String> getHeader(HttpServletRequest request){
        Map<String,String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key,value);
        }
        return map;
    }

    /**
     * 获取 HttpServletRequest Header信息
     * @param request
     * @return
     */
    public static String getHeaderMd5(HttpServletRequest request){
        String s = "";
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            s += key + "=" +value;
        }
        s += request.getQueryString();
        return Md5Util.md5(s);
    }

    public static Map getHttpGetParamMap(HttpServletRequest hrequest){
        String paramStr = hrequest.getQueryString();
        Map<String,String> paramMap = new HashMap<>();
        if(EmptyUtil.isNotEmpty(paramStr) && paramStr.length()>0){
            String[] params = paramStr.split("&");
            for(String param : params){
                String[] keyValue = param.split("=");
                if(keyValue.length>1){
                    paramMap.put(keyValue[0],keyValue[1]);
                }
            }
        }
        return paramMap;
    }

}