package com.example.springbootexcel.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-02-26 10:26
 **/
@Data
public class ReportIndexStateDetailExportVO implements Serializable{
    @Excel(isWrap = false, name = "地市名称",orderNum = "1",width = 30,needMerge = true)
    private String region;

    @Excel(isWrap = false, name = "所属批次",orderNum = "2",width = 30,needMerge = true)
    private String batchName;

    @ExcelCollection(name = "需求阶段",orderNum = "2")
    private List<ReportDemandExportVO> demandList;

    @ExcelCollection(name = "站址筛查",orderNum = "4")
    private List<ReportSiteExportVO> siteList;

    @ExcelCollection(name = "订单阶段",orderNum = "4")
    private List<ReportOrderExportVO> orderList;

    @ExcelCollection(name = "交付阶段",orderNum = "4")
    private List<ReportHandOverExportVO> handOverList;
}
