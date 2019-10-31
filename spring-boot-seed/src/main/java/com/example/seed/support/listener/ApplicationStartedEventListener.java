package com.example.seed.support.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Leon
 * @date 2019/09/3
 */
@Component
@Slf4j
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartedEvent) {
        log.info(">>>>>> Application starting .....");
    }


}
