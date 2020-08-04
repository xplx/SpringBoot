package com.example.springbootrabbitmq.service;

import com.example.springbootrabbitmq.sender.Destination;
import com.example.springbootrabbitmq.sender.TxMessage;


/**
 * 对外提供的服务类接口
 *
 * @author wxp
 */
public interface TransactionalMessageService {
    void sendTransactionalMessage(Destination destination, TxMessage message);
}
