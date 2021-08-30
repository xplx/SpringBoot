package com.example.seed.support.exception;

import com.example.seed.support.utils.Result;
import com.example.seed.support.utils.SpringContextUtil;
import com.example.seed.support.utils.enums.StatusCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.UiConfiguration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author wuxiaopeng
 * @description: 全局异常处理！
 * @date 2019/12/11 14:55
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler implements ResponseBodyAdvice<Object> {

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
                                + "uri:" + uri + "     "
                                + e.getClass().getSimpleName() + ":"
                                + e.getMessage() + "       "
                                + "错误代码行数：" + getStackTrace[0]
                                + " }】");
            }
            return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("服务繁忙，请稍后重试，或联系管理员！");
        }
    }

    @ResponseBody
    @ExceptionHandler(BindException.class)
    public Result bindExceptionErrorHandler(BindException ex) {
        //log.error("bindExceptionErrorHandler info:{}", ex.getMessage());
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : ex.getFieldErrors()) {
            sb.append(fieldError.getDefaultMessage() + ",");
        }
        return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg(sb.toString());
    }

    /**
     * 处理请求对象属性不满足校验规则的异常信息
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result exception(HttpServletRequest request, MethodArgumentNotValidException exception) {
        //log.error("bindExceptionErrorHandler info:{}", ex.getMessage());
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            sb.append(fieldError.getDefaultMessage() + ",");
        }
        return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg(sb.toString());
    }


    /**
     * 统一处理包装类
     *
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return false;
        // 如果接口返回的类型本身就是Result那就没有必要进行额外的操作，返回false
        //return !returnType.getGenericParameterType().equals(Result.class);
    }

    /**
     * 重复键异常处理方法。
     *
     * @param ex       异常对象。
     * @param request  http请求。
     * @return 应答对象。
     */
    @ExceptionHandler(value = DuplicateKeyException.class)
    public Result duplicateKeyExceptionHandle(Exception ex, HttpServletRequest request) {
        log.error("DuplicateKeyException exception from URL [" + request.getRequestURI() + "]", ex);
        return Result.failure().setCode(StatusCode.FAILURE.getCode()).setMsg("数据保存失败，存在重复数据，请核对！");
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("参数类：{}", returnType.getGenericParameterType());
        Type classType = returnType.getGenericParameterType();
        if (classType.equals(SwaggerResource.class) || classType.equals(UiConfiguration.class)) {
            return data;
        }
        // String类型不能直接包装，所以要进行些特别的处理
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在ResultVO里后，再转换为json字符串响应给前端
                return objectMapper.writeValueAsString(Result.ok().setData(data));
            } catch (JsonProcessingException e) {
                throw new CustomException(StatusCode.FAILURE.getCode(), "返回String类型错误");
            }
        } else if (returnType.getGenericParameterType().equals(Page.class)) {
            PageInfo pageInfo = new PageInfo((List) data);
            return Result.ok().setData(pageInfo);
        } else if (returnType.getGenericParameterType().equals(Page.class)) {
            return data;
        }
        // 将原本的数据包装在ResultVO里
        return Result.ok().setData(data);
    }
}
