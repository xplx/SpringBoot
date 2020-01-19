package com.example.seed.support.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.seed.support.utils.EmptyUtil;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuxiaopeng
 * @description: 获取请求的入参和出参
 * @date 2020/1/11 14:22
 */
@Component
@Aspect
public class LogParamInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LogParamInterceptor.class);
    /**
     * 调用controller包下的任意类的任意方法时均会调用此方法
     */
    @Around("execution(* com.example.seed.controller.*.*(..))")
    public Object aroundPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //不需要打印参数类型
        if (interceptType(joinPoint, request)){
            return joinPoint.proceed();
        }

        //IP地址
        String pathUrl = request.getServletPath();
        String ipAddr = getRemoteHost(request);

        String url = request.getRequestURL().toString();
        String reqParam = preHandle(joinPoint, request);
        String swaggerParam = swaggerDescription(joinPoint, request);
        logger.info("业务名称:【{}】,请求源IP:【{}】,请求URL:【{}】,请求参数:【{}】", swaggerParam, ipAddr, pathUrl, reqParam);

        Object result = joinPoint.proceed();
        String respParam = postHandle(result);
        logger.info("业务名称:【{}】,请求源IP:【{}】,请求URL:【{}】,返回参数:【{}】", swaggerParam, ipAddr, url, respParam);
        return result;
    }


    /**
     * 获取目标主机的ip
     *
     * @param request
     * @return
     */
    private String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    /**
     * 返回数据
     * @param retVal
     * @return
     */
    private String postHandle(Object retVal) {
        if (null == retVal) {
            return "";
        }
        return JSON.toJSONString(retVal);
    }

    /**
     * 入参数据
     *
     * @param joinPoint
     * @param request
     * @return
     */
    private String preHandle(ProceedingJoinPoint joinPoint, HttpServletRequest request) {
        String reqParam = "";
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Annotation[] annotations = targetMethod.getAnnotations();
        for (Annotation annotation : annotations) {
            //此处可以改成自定义的注解
            if (getRequestType(annotation)) {
                reqParam = JSON.toJSONString(request.getParameterMap());
                break;
            }
        }
        return reqParam;
    }

    /**
     * 拦截有效类型不需要打印参数(true:不需要打印，false:需要打印)
     * @param joinPoint
     * @param request
     * @return
     */
    private Boolean interceptType(ProceedingJoinPoint joinPoint, HttpServletRequest request){
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Annotation[] annotations = targetMethod.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(ModelAttribute.class)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 入参数据
     *
     * @param joinPoint
     * @param request
     * @return
     */
    private String swaggerDescription(ProceedingJoinPoint joinPoint, HttpServletRequest request) {
        String reqParam = "";
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Annotation[] annotations = targetMethod.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(ApiOperation.class)) {
                //获取swagger属性值
                reqParam = getAnnotationValue(annotation, "value").toString();
                return reqParam;
            }
        }
        return reqParam;
    }

    /**
     * 获取该注解对象的属性值
     * @param annotation
     * @param property
     * @return
     */
    public static Object getAnnotationValue(Annotation annotation, String property) {
        Object result = null;
        if (annotation != null) {
            //获取被代理的对象
            InvocationHandler invocation = Proxy.getInvocationHandler(annotation);
            Map map = (Map) getFieldValue(invocation, "memberValues");
            if (map != null) {
                result = map.get(property);
            }
        }
        return result;
    }

    public static <T> Object getFieldValue(T object, String property) {
        if (object != null && property != null) {
            Class<T> currClass = (Class<T>) object.getClass();
            try {
                Field field = currClass.getDeclaredField(property);
                field.setAccessible(true);
                return field.get(object);
            } catch (NoSuchFieldException e) {
                throw new IllegalArgumentException(currClass + " has no property: " + property);
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private Boolean getRequestType(Annotation annotation){
        Map<Class, Object> map = new HashMap<>();
        map.put(GetMapping.class, 1);
        map.put(PostMapping.class, 2);
        map.put(PutMapping.class, 3);
        map.put(DeleteMapping.class, 4);
        if (EmptyUtil.isEmpty(map.get(annotation.annotationType()))) {
            return false;
        }
        return true;
    }
}
