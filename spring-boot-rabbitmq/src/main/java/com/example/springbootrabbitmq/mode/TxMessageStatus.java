package com.example.springbootrabbitmq.mode;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TxMessageStatus {
    /**
     * 成功
     */
    SUCCESS(1),

    /**
     * 待处理
     */
    PENDING(0),

    /**
     * 处理失败
     */
    FAIL(-1),

    ;

    public Integer getStatus() {
        return status;
    }

    private final Integer status;
}
