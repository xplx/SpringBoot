package com.example.springbootrabbitmq.sender;

/**
 * 事务消息
 */
public interface TxMessage {
    String businessModule();

    String businessKey();

    String content();
}
