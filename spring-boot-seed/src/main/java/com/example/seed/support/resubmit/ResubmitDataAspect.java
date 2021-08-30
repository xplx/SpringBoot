package com.example.seed.support.resubmit;

import com.alibaba.fastjson.JSONObject;
import com.example.seed.model.dto.UserInfoDto;
import com.example.seed.support.utils.Result;
import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author xiaopeng
 * @date 2021年03月25日 10:16
 * @description
 */
@Aspect
@Component
public class ResubmitDataAspect {
    private final static String DATA = "data";
    private final static Object PRESENT = new Object();

    @Around("@annotation(com.example.seed.support.resubmit.Resubmit)")
    public Object handleResubmit(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        //获取注解信息
        Resubmit annotation = method.getAnnotation(Resubmit.class);
        int delaySeconds = annotation.delaySeconds();
        Object[] pointArgs = joinPoint.getArgs();
        String key = "";
        //获取第⼀个参数
        Object firstParam = pointArgs[0];
        if (firstParam instanceof UserInfoDto) {
            //解析参数
            JSONObject requestDTO = JSONObject.parseObject(firstParam.toString());
            JSONObject data = JSONObject.parseObject(requestDTO.getString(DATA));
            if (data != null) {
                StringBuffer sb = new StringBuffer();
                data.forEach((k, v) -> {
                    sb.append(v);
                });
                //⽣成加密参数 使⽤了content_MD5的加密⽅式
                key = ResubmitLock.handleKey(sb.toString());
            }
        }
        //执⾏锁
        boolean lock = false;
        try {
            //设置解锁key
            lock = ResubmitLock.getInstance().lock(key, PRESENT);
            if (lock) {
                //放⾏
                return joinPoint.proceed();
            } else {
                //响应重复提交异常
                return new Result<>().setCode(400).setMsg("信息提交失败");
            }
        } finally {
            //设置解锁key和解锁时间
            ResubmitLock.getInstance().unLock(lock, key, delaySeconds);
        }
    }
}
