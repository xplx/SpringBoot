//package com.example.seed.support.crawler;
//
//import edu.uci.ics.crawler4j.crawler.WebCrawler;
//
//import java.util.regex.Pattern;
//
//public class MyCrawler extends WebCrawler {
//    //定义抓取规则，这里过滤了css、js等等非html的后缀
//    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
//            + "|png|mp3|mp4|zip|gz))$");
//
//    //shouldVisit，应当被获取的url
//    @Override
//    public boolean shouldVisit(Page referringPage, WebURL url) {
//        String href = url.getURL().toLowerCase();
//        return !FILTERS.matcher(href).matches()
//                && href.startsWith("http://www.ics.uci.edu/");
//    }
//
//    //当获取到匹配的URL时，进行处理，我们可以在这里写我们的处理逻辑
//    @Override
//    public void visit(Page page) {
//        String url = page.getWebURL().getURL();
//        System.out.println("URL: " + url);
//
//        if (page.getParseData() instanceof HtmlParseData) {
//            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
//            String text = htmlParseData.getText();
//            String html = htmlParseData.getHtml();
//            Set<WebURL> links = htmlParseData.getOutgoingUrls();
//
//            System.out.println("Text length: " + text.length());
//            System.out.println("Html length: " + html.length());
//            System.out.println("Number of outgoing links: " + links.size());
//        }
//    }
//}
