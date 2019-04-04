package com.example.bee.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-02-26 10:30
 **/
@Data
public class ReportHandOverExportVO {
    @Excel(isWrap = false, name = "新址新建独享站数量",orderNum = "1",width = 30)
    private Integer handoverNewAddressExclusiveNum;//交付阶段新址新建独享数量

    @Excel(isWrap = false, name = "新址新建共享站数量",orderNum = "2",width = 30)
    private Integer handoverNewAddressSharedNum;//交付阶段新址新建共享数量

    @Excel(isWrap = false, name = "共址新建数量",orderNum = "3",width = 15)
    private Integer handoverCoAddressNum;//交付阶段共址新建数量

    @Excel(isWrap = false, name = "当前共享率",orderNum = "4",suffix = "%",width = 15)
    private String handoverShareRateCurr;//交付阶段共享率
}
