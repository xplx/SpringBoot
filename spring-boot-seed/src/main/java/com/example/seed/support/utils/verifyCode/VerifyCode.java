package com.example.seed.support.utils.verifyCode;

import lombok.Data;

/**
 * @author wuxiaopeng
 * @description: 验证码类
 * @date 2020/5/1 9:21
 */
@Data
public class VerifyCode {
    private String code;

    private byte[] imgBytes;

    private long expireTime;
}
