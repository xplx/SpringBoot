/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/3/11 14:46
 */
public class Test {
    public static void main(String[] args) {
        int a = 1;
        new Test().f1(a);
        System.out.println(a);
        int[] b = {1, 2};
        new Test().f2(b);
        System.out.println(b[0]);
    }

    public void f1(int a) {
        a = a + 1;
        System.out.println(a);
    }

    public void f2(int[] a) {
        a[0] = a[0] + 1;
        System.out.println(a[0]);
    }
}
