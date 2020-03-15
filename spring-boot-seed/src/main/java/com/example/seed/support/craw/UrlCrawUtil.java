package com.example.seed.support.craw;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wuxiaopeng
 * @description: 获取指定博客所有数据
 * @date 2020/3/11 16:22
 */
public class UrlCrawUtil {
    static String userId = "xp_lx1";

    public static void main(String urlstr[]) throws IOException, InterruptedException {

        // ---------------------------------------------------打印每个链接---------------------------------------------------
        System.out.println("打印每个链接");
        for (String s : getAllBlog()) {
            System.out.println(s);
        }
        System.out.println("打印每个链接完毕");
        int i = 0;

        // ---------------------------------------------------访问每个链接---------------------------------------------------
        while (true) {
            doGet("https://blog.csdn.net/xp_lx1/article/details/103392812");
            Thread.sleep(20000);
            doGet("https://blog.csdn.net/xp_lx1/article/details/104722832");
            Thread.sleep(20000);
            doGet("https://blog.csdn.net/xp_lx1/article/details/103386823");
            Thread.sleep(20000);
            System.out.println("成功访问第" + (++i));
        }
        // ---------------------------------------------------程序结束---------------------------------------------------
        //System.out.println("运行完毕，成功增加访问数：" + urls.size());
    }

    public static Set<String>getAllBlog() throws InterruptedException, IOException {
        Set<String> urls = new HashSet<String>();
        // ----------------------------------------------遍历每一页 获取文章链接----------------------------------------------
        // 后面加pageNum即可
        final String homeUrl = "https://blog.csdn.net/" + userId + "/article/list/";
        int totalPage = 0;
        InputStream is;
        String pageStr;
        StringBuilder curUrl = null;
        for (int i = 1; i < 100; i++) {
            Thread.sleep(1000);
            System.out.println("finding page " + i);
            curUrl = new StringBuilder(homeUrl);
            curUrl.append(i);
            System.out.println(curUrl);
            is = doGet(curUrl.toString());
            // 一整页的html源码
            pageStr = inputStreamToString(is, "UTF-8");
            List<String> list = getMatherSubstring(pageStr, "(?<=href=\")https://blog.csdn.net/" + userId + "/article/details/[0-9]{8,9}(?=\")");
            urls.addAll(list);
            if (pageStr.lastIndexOf("空空如也") != -1) {
                System.out.println("No This Page!");
                break;
            } else {
                System.out.println("Success~");
            }
            totalPage = i;
        }
        System.out.println("总页数为: " + totalPage);
        return urls;
    }

    public static InputStream doGet(String urlstr) throws IOException {
        URL url = new URL(urlstr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        InputStream inputStream = conn.getInputStream();
        return inputStream;
    }

    public static String inputStreamToString(InputStream is, String charset) throws IOException {
        byte[] bytes = new byte[1024];
        int byteLength = 0;
        StringBuffer sb = new StringBuffer();
        while ((byteLength = is.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, byteLength, charset));
        }
        return sb.toString();
    }

    /**
     * 正则匹配
     *
     * @param str
     * @param regex
     * @return
     */
    public static List<String> getMatherSubstring(String str, String regex) {
        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()) {
            list.add(m.group());
        }
        return list;
    }
}
