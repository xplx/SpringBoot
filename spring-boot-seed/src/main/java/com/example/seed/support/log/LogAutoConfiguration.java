package com.example.seed.support.log;

import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({Logger.class})
public class LogAutoConfiguration {
    public LogAutoConfiguration() {
    }

    @Bean
    public LogProcessorTest logProcessorTest() {
        return new LogProcessorTest();
    }
}
