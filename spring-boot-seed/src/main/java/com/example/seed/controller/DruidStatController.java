package com.example.seed.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/4/24 14:55
 */
@Api(tags = "druid管理 DruidStatController")
@RequestMapping("/druid")
public class DruidStatController {
    @GetMapping("/stat")
    @ApiOperation("如何获取 Druid 的监控数据")
    public Object druidStat(){
        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }
}
