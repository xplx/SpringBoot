package com.example.seed.support.craw.util;

import cn.hutool.core.io.file.FileWriter;
import com.example.seed.support.craw.other.IPBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.*;
import java.util.NoSuchElementException;

public class IPUtils {
    private static final String MY_IP_API = "https://www.ipip.net/ip.html";

    // 获取当前ip地址，判断是否代理成功
    public static String getMyIp() {
        try {
            String html = HttpUtils.getResponseContent(MY_IP_API);

            Document doc = Jsoup.parse(html);
            Element element = doc.selectFirst("div.tableNormal");

            Element ele = element.selectFirst("table").select("td").get(1);

            String ip = element.selectFirst("a").text();

            // System.out.println(ip);
            return ip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 检测代理ip是否有效
     *
     * @param ipBean
     * @return
     */
    public static boolean isValid(IPBean ipBean) {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ipBean.getIp(), ipBean.getPort()));
        try {
            URLConnection httpCon = new URL("https://blog.csdn.net/").openConnection(proxy);
            httpCon.setConnectTimeout(20000);
            httpCon.setReadTimeout(20000);
            int code = ((HttpURLConnection) httpCon).getResponseCode();
            System.out.println("有效ip地址：" + ipBean);
            FileWriter writer = new FileWriter("D:\\ip.txt");
            writer.append(ipBean.getIp() + ":" + ipBean.getPort() + "\n");
            return code == 200;
        } catch (IOException io) {
            System.out.println("io:" + io.getMessage());
        } catch (NoSuchElementException no) {
            System.out.println("no:" + no.getMessage());
        } catch (Exception e) {
            System.out.println("exception" + e.getMessage());
        }
        return false;
    }
}
