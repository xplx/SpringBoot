package com.example.springbootexcel.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-02-26 10:29
 **/
@Data
public class ReportDemandExportVO {
    @Excel(isWrap = false, name = "新址新建",orderNum = "1",width = 15)
    private Integer demandNewAddressNum;//需求阶段新址新建数量

    @Excel(isWrap = false, name = "共址新建",orderNum = "2",width = 15)
    private Integer demandCoAddressNum;//需求阶段共址新建数量
}
