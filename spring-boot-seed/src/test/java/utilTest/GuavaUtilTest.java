package utilTest;

import java.util.Optional;

/**
 * @author wuxiaopeng
 * @description: 谷歌开源代码库
 * @date 2020/1/21 11:38
 */
public class GuavaUtilTest {
    public static void main(String args[]){
        GuavaUtilTest guavaTester = new GuavaUtilTest();
        Integer invalidInput = 1;
        Optional<Integer> a =  Optional.of(invalidInput);
        Optional<Integer> b =  Optional.of(new Integer(10));
        System.out.println(guavaTester.sum(a,b));


    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){
        return a.get() + b.get();
    }
}
