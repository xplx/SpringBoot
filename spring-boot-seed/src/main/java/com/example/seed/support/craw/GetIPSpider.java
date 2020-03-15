package com.example.seed.support.craw;


import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import com.example.seed.support.craw.other.IPBean;
import com.example.seed.support.craw.other.IPList;
import com.example.seed.support.craw.other.IPSpider;
import com.example.seed.support.craw.util.IPUtils;
import org.apache.tika.parser.iptc.IptcAnpaParser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

/**
 * 获取代理ip并且保存到磁盘
 *
 * @author Asche
 * @github: https://github.com/asche910
 * @date 2019年1月19日
 */
public class GetIPSpider {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
//        System.out.println("Start: ");
//        Integer validCount = 0;
//        IPSpider spider = new IPSpider();
//        List<IPBean> list = spider.crawlHttp(210);
//        System.out.println("爬取数量：" + list.size());
//        for (IPBean ipBean : list) {
//            FileWriter writer = new FileWriter("D:\\allIp.txt");
//            writer.append(ipBean.getIp() + ":" + ipBean.getPort() + "\n");
//        }

        FileReader list = new FileReader("D:\\allIp.txt");
        //开启线程池
        System.out.println("开始时间:" + sdf.format(new Date()));
        Long beginTime = System.currentTimeMillis();

//        ExecutorService exe = Executors.newFixedThreadPool(list.readLines().size());
//        for (String str : list.readLines()) {
//            exe.execute(new Runnable() {
//                @Override
//                public void run() {
//                    String[] ipPort = str.split(":");
//                    IPBean ipBean = new IPBean(ipPort[0], Integer.parseInt(ipPort[1]), 0);
//                    boolean valid = IPUtils.isValid(ipBean);
//                    if (valid) {
//                        IPList.add(ipBean);
//                    }
//                    IPList.increase();
//                }
//            });
//        }
//        /**停止接收新任务，原来的任务继续执行*/
//        exe.shutdown();

        for (String str : list.readLines()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String[] ipPort = str.split(":");
                    IPBean ipBean = new IPBean(ipPort[0], Integer.parseInt(ipPort[1]), 0);
                    boolean valid = IPUtils.isValid(ipBean);
                    if (valid) {
                        IPList.add(ipBean);
                    }
                    IPList.increase();
                }
            }).start();
        }

        while (true) {
//            int threadCount = ((ThreadPoolExecutor)exe).getActiveCount();
//            System.out.println("当前线程数："+threadCount);
            //所有线程执行完成
            if (IPList.getCount() == list.readLines().size()) {
                Long endTime = System.currentTimeMillis();
                System.out.println("执行时间:" + (endTime - beginTime));
                System.out.println("结束时间:" + sdf.format(new Date()));
                System.out.println("有效ip总数：" + IPList.getSize());
            }
        }
    }
}
