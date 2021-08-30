package mapstruct;


import com.example.seed.model.convert.UserInfoWrap;
import com.example.seed.model.convert.impl.UserInfoWrapImpl;
import com.example.seed.model.entity.Shop;
import com.example.seed.model.vo.ShopVO;
import java.util.ArrayList;
import java.util.List;

public class MapStructTest {
    public static void main(String[] args) {
        List<Shop> shopList = new ArrayList<Shop>();
        Shop carPo = Shop.builder().id(1)
                .name("测试用户")
                .shopId(12)
                .build();
        Shop carPo1 = Shop.builder().id(2)
                .name("测试用户1")
                .shopId(13)
                .build();
        ShopVO carVo = UserInfoWrapImpl.INSTANCE.toConvertVo(carPo);
        System.out.println(carVo);

        shopList.add(carPo);
        shopList.add(carPo1);
        List<ShopVO> shopVOList = UserInfoWrap.INSTANCE.toConvertVoList(shopList);
        System.out.println(shopVOList);
    }
}
