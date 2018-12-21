package com.example.druid;

import com.example.druid.pojo.StatisticOrder;
import com.example.druid.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDuridApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void contextLoads() {
        StatisticOrder order = new StatisticOrder();
        order.setSource("12");
        order.setActno("123");
        order.setActname("123");
        order.setChannel(0);
        order.setClue("ew");
        order.setStarLevel("1");
        order.setSaledep("df");
        order.setStyle("dffg");
        order.setStatus(0);
        order.setSyctimeDay("2016-05-01");
        orderService.saveOrderInfo(order);
    }
}
