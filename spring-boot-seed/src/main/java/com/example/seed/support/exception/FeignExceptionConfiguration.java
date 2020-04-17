package com.example.seed.support.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.seed.support.utils.enums.StatusCode;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;


/**
 * @author wuxiaopeng
 * @description: 实现Feign的异常处理类
 * @date 2020/3/19 11:26
 */
@Slf4j
@Configuration
public class FeignExceptionConfiguration {
    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }

    public class FeignErrorDecoder implements ErrorDecoder {

        @Override
        public Exception decode(String methodKey, Response response) {
            Exception exception = null;
            try {
                String json = Util.toString(response.body().asReader());
                if (StringUtils.isEmpty(json)) {
                    return null;
                }
                JSONObject jsonObject = JSON.parseObject(json);
                // 业务异常包装成自定义异常类CustomException
                if (response.status() != HttpStatus.OK.value()) {
                    Integer code = Integer.valueOf(jsonObject.get("status") + "");
                    String message = "Feign调用失败,URL:" + jsonObject.get("path") +
                            " 错误原因：" + jsonObject.get("message") + "";
                    exception = new CustomException(code, message);
                }
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
                return new CustomException(StatusCode.FAILURE.getCode(), ex.getMessage());
            }
            return exception;
        }
    }
}
