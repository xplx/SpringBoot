package com.example.springbootmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootMqApplication {

	public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
		ApplicationContext context = SpringApplication.run(SpringBootMqApplication.class,args);
		DefaultMQProducer defaultMQProducer = context.getBean(DefaultMQProducer.class);
		Message msg = new Message("TEST",// topic
				"TEST",// tag
				"KKK",//key用于标识业务的唯一性
				("Hello RocketMQ !!!!!!!!!!" ).getBytes()// body 二进制字节数组
		);
		SendResult result = defaultMQProducer.send(msg);
		System.out.println(result);
		DefaultMQPushConsumer consumer = context.getBean(DefaultMQPushConsumer.class);
	}
}
