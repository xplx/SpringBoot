package mapstruct;


import com.example.seed.model.convert.ShopConvert;
import com.example.seed.model.entity.Shop;
import com.example.seed.model.entity.ShopDetail;
import com.example.seed.model.vo.ShopVO;
import java.util.ArrayList;
import java.util.List;

public class MapStructTest {
    public static void main(String[] args) {
        List<Shop> shopList = new ArrayList<Shop>();
        Shop carPo = Shop.builder().id(1)
                .name("测试用户")
                .shopId(12)
                .age(65)
                .build();
        Shop carPo1 = Shop.builder().id(2)
                .name("测试用户1")
                .shopId(13)
                .age(60)
                .build();
        ShopDetail detail = ShopDetail.builder().address("贵阳市").build();
        ShopVO carVo = ShopConvert.INSTANCE.toConvertVo(carPo);
        System.out.println(carVo);
        ShopVO shopVO = ShopConvert.INSTANCE.toConvertMoreVo(detail, carPo);
        System.out.println(shopVO);
        shopList.add(carPo);
        shopList.add(carPo1);
        List<ShopVO> shopVOList = ShopConvert.INSTANCE.toConvertVoList(shopList);
        System.out.println(shopVOList);
    }
}
