package com.example.seed.support.craw;


import com.example.seed.support.craw.other.IPBean;
import com.example.seed.support.craw.other.IPList;
import com.example.seed.support.craw.other.IPSpider;
import com.example.seed.support.craw.util.IPUtils;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 获取代理ip并且保存到磁盘
 *
 * @author Asche
 * @github: https://github.com/asche910
 * @date 2019年1月19日
 */
public class GetIpSpider {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        System.out.println("Start: ");
        Integer validCount = 0;
        IPSpider spider = new IPSpider();
        List<IPBean> list = spider.crawlHttp(240);
        System.out.println("爬取数量：" + list.size());

        //开启线程池
        System.out.println("开始时间:" + sdf.format(new Date()));
        Long beginTime = System.currentTimeMillis();

        ExecutorService exe = Executors.newFixedThreadPool(list.size());
        for (IPBean ipBean : list) {
            exe.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    boolean valid = IPUtils.isValid(ipBean);
                    if (valid) {
                        IPList.add(ipBean);
                    }
                    IPList.increase();
                    Thread.sleep(100);
                }
            });
        }
        /**停止接收新任务，原来的任务继续执行*/
        exe.shutdown();
        Thread.sleep(20000);

        /**new 新的线程*/
//        for (String str : list.readLines()) {
//            new Thread(new Runnable() {
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
//            }).start();
//        }

        while (true) {
//            int threadCount = ((ThreadPoolExecutor) exe).getActiveCount();
//            System.out.println("当前线程数：" + threadCount);
            //所有线程执行完成
            if (IPList.getCount() == list.size()) {
                Long endTime = System.currentTimeMillis();
                System.out.println("执行时间:" + (endTime - beginTime));
                System.out.println("结束时间:" + sdf.format(new Date()));
                System.out.println("有效ip总数：" + IPList.getSize());
                return;
            }
        }
    }
}
