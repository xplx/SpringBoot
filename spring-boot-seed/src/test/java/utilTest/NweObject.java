package utilTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wuxiaopeng
 * @description: new 对象
 * @date 2020/3/11 9:16
 */
public class NweObject {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        String d1 = sdf.format(new Date());
//        Iterator<Integer> iterable = list.iterator();
//        int i = 0;
//        while (iterable.hasNext()) {
//            System.out.println(iterable.next());
//        }
//        for (Integer i : list) {
//            System.out.println(i);
//        }
        int count = list.size();
        for (int i = 0; i < count; i++) {
            System.out.println(i);
        }
        System.out.println(d1);
        System.out.println(sdf.format(new Date()));
    }
}
