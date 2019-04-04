package com.example.bee.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-02-26 10:58
 **/
@Data
public class MultiExcelModelVo extends BaseRowModel{
    @ExcelProperty(value = {"表头1",  "表头2"}, index = 0)
    private String p1;
    @ExcelProperty(value = {"表头1",  "表头3"}, index = 1)
    private String p2;
    @ExcelProperty(value = {"表头1",  "表头2",  "表头4"}, index = 1)
    private String p3;
    @ExcelProperty(value = {"表头1",  "表头2","表头4"}, index = 1)
    private String p4;
}
