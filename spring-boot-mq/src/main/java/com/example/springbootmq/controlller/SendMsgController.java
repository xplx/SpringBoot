package com.example.springbootmq.controlller;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.example.springbootmq.SpringBootMqApplication;
import com.example.springbootmq.config.RocketMQProducerConfiguration;
import com.example.springbootmq.util.RocketMQException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/send")
public class SendMsgController  {
    public static final Logger LOGGER = LoggerFactory.getLogger(RocketMQProducerConfiguration.class);
    @RequestMapping("msg")
    public String SendMsg(String sendMsg) throws RocketMQException{
        DefaultMQProducer producer = new DefaultMQProducer("vehicleProducerGroup");
        producer.setNamesrvAddr("127.0.0.1:9876");
        try {
                producer.start();
                Message msg = new Message("broker-a",// topic
                        "TagB",// tag
                        "OrderID002",// key
                        ("Hello MetaQ2").getBytes());// body
                SendResult sendResult = producer.send(msg);
                System.out.println(sendResult);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
