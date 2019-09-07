package com.example.bee.controller;

import com.example.bee.mapper.TbSellOrderMapper;
import com.example.bee.service.OrderService;
import com.example.bee.utils.R;
import com.example.bee.utils.enums.StatusCode;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-02-26 15:06
 **/
@RestController
@RequestMapping(value = "/Order")
public class SellOrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private TbSellOrderMapper tbSellOrderMapper;


    @ApiOperation("排除用户偏好--查询商品档案（分页）")
    @RequestMapping(value = "/findOrderBuyInfo")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType = "query",dataType = "int", name = "userId",value = "用户id"),
            @ApiImplicitParam( paramType = "query",dataType = "string", name = "commodityName",value = "商品名称"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageNum", value = "起始页"),
            @ApiImplicitParam(paramType = "query", dataType = "Integer", name = "pageSize", value = "页大小")
    })
    public R findOrderBuyInfo(  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
        List<Map<String, Object>> mapList = new ArrayList<>();
        try {
            PageHelper.startPage(pageNum, pageSize);
            mapList = orderService.findOrderBuyInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return R.failure(StatusCode.FAILED, "查询异常！");
        }
        return R.ok().setData(mapList);
    }
}
