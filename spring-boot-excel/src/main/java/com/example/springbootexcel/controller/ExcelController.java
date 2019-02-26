package com.example.springbootexcel.controller;

import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.springbootexcel.utils.ExcelAli.ExcelUtil;
import com.example.springbootexcel.utils.ExcelPoiUtil;
import com.example.springbootexcel.vo.MultiExcelModelVo;
import com.example.springbootexcel.vo.ReportIndexStateDetailExportVO;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:控制层
 * @author:wuxiaopeng
 * @create: 2019-02-26 10:22
 **/
@RequestMapping(value = "/excel")
@Controller
public class ExcelController {
    /**
     * 导出 批次指标各阶段数据统计
     * easypoi的多表头导出
     * */
    @RequestMapping(value = "/exportEasypoi", method = RequestMethod.GET)
    public void exportEasypoi(HttpServletResponse response) {
        // 设置导出参数
        List<ReportIndexStateDetailExportVO> list = new ArrayList<>();
        try {
            //导出操作
            ExcelPoiUtil.exportExcel(list,null,"商品列表",
                    ReportIndexStateDetailExportVO.class,"commodity_upload_template.xls",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 导出 批次指标各阶段数据统计
     * AliExcel的多表头导出
     * */
    @RequestMapping(value = "/exportAliExcel", method = RequestMethod.GET)
    public void exportAliExcel(HttpServletResponse response) {
        try {
            List<MultiExcelModelVo> list = new ArrayList<>();
            String fileName = "一个 Excel文件";
            String sheetName = "第一个 sheet";
            ExcelUtil.writeExcel(response, list, fileName, sheetName, new MultiExcelModelVo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
