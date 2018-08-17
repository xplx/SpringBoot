package com.example.springbootmq.service.impl;

import com.alibaba.rocketmq.common.message.MessageExt;
import com.example.springbootmq.service.MessageProcessor;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessorImplTest implements MessageProcessor {
    @Override
    public boolean handleMessage(MessageExt messageExt) {
        System.out.println("receive : " + messageExt.toString());
        return true;
    }
}
