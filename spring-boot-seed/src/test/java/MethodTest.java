import com.example.seed.model.entity.Shop;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/1/11 15:20
 */
public class MethodTest {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.setId(0);
        shop.setShopId(0);

        Shop shop1 = new Shop();
        shop1.setId(0);
        shop1.setShopId(0);
        System.out.println(shop.equals(shop1));

    }

    public static void getInfo(){
        String location="";
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        location = "类名："+stacks[2].getClassName() + "\n函数名：" + stacks[2].getMethodName()
                + "\n文件名：" + stacks[2].getFileName() + "\n行号："
                + stacks[2].getLineNumber() + "";
        System.out.println(location);
        for(int i=0;i<stacks.length;i++){
            location = i+"  at "+stacks[i].getClassName() + "." + stacks[i].getMethodName()
                    + "(" + stacks[i].getFileName() + ":"
                    + stacks[i].getLineNumber() + ")";
            System.out.println(location);
        }
    }
}
