import com.alibaba.fastjson.JSON;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static jdk.internal.dynalink.CallSiteDescriptor.OPERATOR;

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
        int a = 2 / 0;
        list.get(2);
        System.out.println("回滚代码");
        for (int i = 0; i < 12; i++) {
            list.add("测试");
        }
        System.out.println(list);
    }
}