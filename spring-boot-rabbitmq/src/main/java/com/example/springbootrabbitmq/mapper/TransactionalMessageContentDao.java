package com.example.springbootrabbitmq.mapper;

import com.example.springbootrabbitmq.mode.TransactionalMessageContent;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionalMessageContentDao {
    void insert(TransactionalMessageContent record);

    List<TransactionalMessageContent> queryByMessageIds(String messageIds);
}
