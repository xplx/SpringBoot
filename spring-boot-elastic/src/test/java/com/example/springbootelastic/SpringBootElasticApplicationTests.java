package com.example.springbootelastic;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootElasticApplicationTests {

    @Test
    public void contextLoads() throws Exception {
        Settings settings = Settings.builder()
                .put("cluster.name", "my-application")
                .build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.137.137"), 9300));
        createEmployee(client);
        client.close();
    }

    //构建员工信息（创建一个document）
    private void createEmployee(TransportClient client) throws Exception {
        client.prepareIndex("company", "employee", "2")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name", "punch")
                        .field("age", 31)
                        .field("position", "moju many")
                        .field("country", "china")
                        .field("join-date", "2017-01-17")
                        .field("salary", 9000).endObject()).get();

        client.prepareIndex("company", "employee", "3")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name", "jack")
                        .field("age", 35)
                        .field("position", "jixie technique")
                        .field("country", "china")
                        .field("join-date", "2013-02-17")
                        .field("salary", 5000).endObject()).get();

        client.prepareIndex("company", "employee", "4")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name", "many")
                        .field("age", 40)
                        .field("position", "yinhang technique")
                        .field("country", "china")
                        .field("join-date", "2013-03-17")
                        .field("salary", 11000).endObject()).get();

        client.prepareIndex("company", "employee", "5")
                .setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name", "punny")
                        .field("age", 28)
                        .field("position", "wenyuan technique")
                        .field("country", "china")
                        .field("join-date", "2015-04-17")
                        .field("salary", 3000).endObject()).get();
    }
}
