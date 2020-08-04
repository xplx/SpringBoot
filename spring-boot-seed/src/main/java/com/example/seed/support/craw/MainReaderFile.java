package com.example.seed.support.craw;


import cn.hutool.core.io.file.FileReader;
import com.example.seed.support.craw.other.IPBean;
import com.example.seed.support.craw.other.IPList;
import com.example.seed.support.craw.other.IPSpider;
import com.example.seed.support.craw.util.IPUtils;
import io.swagger.models.auth.In;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Asche
 * @github: https://github.com/asche910
 * @date 2019年1月19日
 */
public class MainReaderFile {
    public static void main(String[] args) throws InterruptedException, IOException {
        accessKuaiShou();
    }

    private static void accessKuaiShou() throws InterruptedException {
        FileReader fileReader = new FileReader("D:\\ip.txt");
        System.out.println("ip总数：" + fileReader.readLines().size());
        int count = 0;
        //获取所有博客ip地址
        String[] accessIps = new String[]{"https://live.kuaishou.com/u/3xxdggu79ueqjb6/3xk2fb4dt4hebzu?did=web_cdea2527bc0fcefe1a799be8498cbfeb"};
        while (true) {
            System.out.println("循环次数：" + count++);
            //开启线程池
            ExecutorService exe = Executors.newFixedThreadPool(fileReader.readLines().size());
            for (String str : fileReader.readLines()) {
                String[] ips = str.split(":");
                String ip = ips[0];
                int port = Integer.parseInt(ips[1]);
                checkIp checkIp = new checkIp(ip, port, fileReader.readLines().size(), accessIps);
                exe.execute(checkIp);
                Thread.sleep(10);
            }
            Thread.sleep(10000);
            exe.shutdown();
        }
    }

    /**
     * 访问CSDN博客
     */
    private static void accessCSDN() throws IOException, InterruptedException {
        FileReader fileReader = new FileReader("D:\\ip.txt");
        System.out.println("ip总数：" + fileReader.readLines().size());
        int count = 0;
        //获取所有博客ip地址
        Set<String> stringSet = new HashSet<>();
        if (stringSet.size() == 0) {
            stringSet = UrlCrawUtil.getAllBlog();
        }
        String[] accessIps = stringSet.toArray(new String[stringSet.size()]);
        while (true) {
            System.out.println("循环次数：" + count++);
            //开启线程池
            ExecutorService exe = Executors.newFixedThreadPool(fileReader.readLines().size());
            for (String str : fileReader.readLines()) {
                String[] ips = str.split(":");
                String ip = ips[0];
                int port = Integer.parseInt(ips[1]);
                checkIp checkIp = new checkIp(ip, port, fileReader.readLines().size(), accessIps);
                exe.execute(checkIp);
                Thread.sleep(10);
            }
            Thread.sleep(10000);
            exe.shutdown();
        }
    }
}
