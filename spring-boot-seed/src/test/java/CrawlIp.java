import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author wuxiaopeng
 * @description: 获取代理ip
 * @date 2020/3/13 17:53
 */
public class CrawlIp {
    public static void main(String[] args) {

    }

    private List<IPBean> crawl(String api, int index){
        String html = HttpUtils.getResponseContent(api + index);
        System.out.println(html);

        Document document = Jsoup.parse(html);
        Elements eles = document.selectFirst("table").select("tr");

        for (int i = 0; i < eles.size(); i++){
            if (i == 0) continue;
            Element ele = eles.get(i);
            String ip = ele.children().get(1).text();
            int port = Integer.parseInt(ele.children().get(2).text().trim());
            String typeStr = ele.children().get(5).text().trim();

            int type;
            if ("HTTP".equalsIgnoreCase(typeStr))
                type = IPBean.TYPE_HTTP;
            else
                type = IPBean.TYPE_HTTPS;

            IPBean ipBean = new IPBean(ip, port, type);
            ipList.add(ipBean);
        }
        return ipList;
    }
}
