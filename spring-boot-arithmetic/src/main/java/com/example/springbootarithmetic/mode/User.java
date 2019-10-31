package com.example.springbootarithmetic.mode;

import lombok.Builder;
import lombok.Data;

/**
 * @author wuxiaopeng
 * @description: 实体类
 * @date 2019/7/2 16:09
 */
@Data
@Builder
public class User {
    private String username;

    private String password;
}
