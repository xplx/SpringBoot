import java.util.ArrayList;
import java.util.List;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/3/11 14:46
 */
public class Test {
    public static void main(String[] args) {
//        String doubleStr = "1.00000000";
//        System.out.println(doubleStr.indexOf("."));
//        doubleStr = doubleStr.substring(0, doubleStr.indexOf("."));
//        System.out.println(doubleStr);

        List<String> list = new ArrayList();
        for (int i = 0; i < 12; i++) {
            list.add("测试");
        }
        System.out.println(list);
    }
}
