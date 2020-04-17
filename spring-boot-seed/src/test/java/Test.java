/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/3/11 14:46
 */
public class Test {
    public static void main(String[] args) {
        String doubleStr = "1.00000000";
        System.out.println(doubleStr.indexOf("."));
        doubleStr = doubleStr.substring(0, doubleStr.indexOf("."));
        System.out.println(doubleStr);
    }
}
