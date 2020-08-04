package com.example.springbootrabbitmq.mapper;

import com.example.springbootrabbitmq.mode.TransactionalMessage;
import jodd.introspector.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionalMessageDao {
    void insertSelective(TransactionalMessage record);

    void updateStatusSelective(TransactionalMessage record);

    List<TransactionalMessage> queryPendingCompensationRecords(LocalDateTime minScheduleTime,
                                                               LocalDateTime maxScheduleTime,
                                                               int limit);
}
