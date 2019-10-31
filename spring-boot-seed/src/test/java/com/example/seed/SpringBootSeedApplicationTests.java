package com.example.seed;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootSeedApplication.class)
@Slf4j
class SpringBootSeedApplicationTests {

    @Test
    void contextLoads() {
        log.info("测试使用");
    }

}
