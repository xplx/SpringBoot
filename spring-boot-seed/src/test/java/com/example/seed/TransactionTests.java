package com.example.seed;
import java.util.Date;

import com.example.seed.model.entity.Location;
import com.example.seed.model.entity.User;
import com.example.seed.service.LocationService;
import com.example.seed.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootSeedApplication.class)
@Slf4j
class TransactionTests {
    @Resource
    private UserService userService;
    @Resource
    private LocationService locationService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setName("测试使用");
        user.setAge(0);
        user.setEmail("1099@qq.com");
        user.setCreateDate(new Date());
        userService.saveUser(user);

        Location location = new Location();
        location.setName("测试测试");
        locationService.saveLocation(location);

        //throw new RuntimeException();
    }

}
