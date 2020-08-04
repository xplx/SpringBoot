package com.example.springbootrabbitmq.mode;

import lombok.Data;

@Data
public class TransactionalMessageContent {
    private Long id;
    private Long messageId;
    private String content;
}
