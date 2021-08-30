package com.example.seed;

import com.example.seed.model.entity.Address;
import com.example.seed.model.entity.Location;
import com.example.seed.service.AddressService;
import com.example.seed.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootSeedApplication.class)
@Slf4j
class TransactionTests {
    @Resource
    private AddressService addressService;
    @Resource
    private LocationService locationService;

    @Test
    void contextLoads() {
        Address user = new Address();
        user.setName("测试使用");
        user.setAge(0);
        addressService.save(user);

        Location location = new Location();
        location.setName("测试测试");
        locationService.saveLocation(location);

        //throw new RuntimeException();
    }

}
