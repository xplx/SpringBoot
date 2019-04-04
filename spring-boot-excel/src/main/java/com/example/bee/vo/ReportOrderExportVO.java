package com.example.bee.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-02-26 10:30
 **/
@Data
public class ReportOrderExportVO {
    @Excel(isWrap = false, name = "新址新建独享站数量",orderNum = "1",width = 30)
    private Integer orderNewAddressExclusiveNum;//订单阶段新址新建独享数量

    @Excel(isWrap = false, name = "新址新建共享站数量",orderNum = "2",width = 30)
    private Integer orderNewAddressSharedNum;//订单阶段新址新建共享数量

    @Excel(isWrap = false, name = "共址新建数量",orderNum = "3",width = 15)
    private Integer orderCoAddressNum;//订单阶段共址新建数量

    @Excel(isWrap = false, name = "当前共享率",orderNum = "4",suffix = "%",width = 15)
    private String orderShareRateCurr;//订单阶段共享率
}
