package com.example.springbootrabbitmq.sender;

import com.example.springbootrabbitmq.mode.ExchangeType;

public interface Destination {
    ExchangeType exchangeType();

    String queueName();

    String exchangeName();

    String routingKey();
}
