package com.example.seed.support.exception;

import com.example.seed.support.utils.Result;
import com.example.seed.support.utils.SpringContextUtil;
import com.example.seed.support.utils.enums.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wuxiaopeng
 * @description: 全局异常处理！
 * @date 2019/12/11 14:55
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e, HttpServletRequest req, HttpServletResponse response) {
        String uri = req.getRequestURI();
        if (e instanceof CustomException) {
            CustomException ce = (CustomException) e;
            log.error("uri:【{}】 message:【{}】", uri, ce.getMessage(), ce);
            return Result.failure().setCode(ce.getStatusCode()).setMsg(ce.getMessage());
        } else {
            log.error("uri:【{}】 message:【{}】", uri, e.getMessage(), e);
            StackTraceElement[] getStackTrace = e.getStackTrace();
            String profile = SpringContextUtil.getActiveProfile();
            if ("dev".equals(profile) || "test".equals(profile)) {
                return Result.failure().setCode(StatusCode.FAILURE.getCode()).
                        setMsg("服务接口异常:【{"
                                + "uri:" + uri +"     "
                                + e.getClass().getSimpleName() + ":"
                                + e.getMessage() + "       "
                                + "错误代码行数：" + getStackTrace[0]
                                + " }】");
            }
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("服务繁忙，请稍后重试，或联系管理员！");
        }
    }
}
