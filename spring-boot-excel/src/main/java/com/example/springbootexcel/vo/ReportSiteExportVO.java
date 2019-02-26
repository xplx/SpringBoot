package com.example.springbootexcel.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-02-26 10:29
 **/
@Data
public class ReportSiteExportVO {
    @Excel(isWrap = false, name = "新址新建独享站数量",orderNum = "1",width = 30)
    private Integer siteNewAddressExclusiveNum;//站址筛查阶段新址新建独享数量

    @Excel(isWrap = false, name = "新址新建共享站数量",orderNum = "2",width = 30)
    private Integer siteNewAddressSharedNum;//站址筛查阶段新址新建共享数量

    @Excel(isWrap = false, name = "共址新建数量",orderNum = "3",width = 15)
    private Integer siteCoAddressNum;//站址筛查阶段共址新建数量

    @Excel(isWrap = false, name = "当前共享率",orderNum = "4",suffix = "%",width = 15)
    private String siteShareRateCurr;//站址筛查阶段共享率

}
