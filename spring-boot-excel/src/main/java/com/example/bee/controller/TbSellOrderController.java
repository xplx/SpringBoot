package com.example.bee.controller;

import com.example.bee.mode.TbSellOrder;
import com.example.bee.mode.TbSellOrderExample;
import com.example.bee.utils.ExcelAli.ExcelUtil;
import com.example.bee.vo.TbSellOrderVo;
import com.example.bee.mapper.TbSellOrderMapper;
import com.example.bee.utils.ExcelPoiUtil;
import com.example.bee.vo.TbSellOrderPoiVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-02-26 15:06
 **/
@Controller
@RequestMapping(value = "Order")
public class TbSellOrderController {
    @Resource
    private TbSellOrderMapper tbSellOrderMapper;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");

    public void exportAli(){

    }
    /**
     * 导出 Excel（一个 sheet）
     */
    @RequestMapping(value = "writeAliExcel", method = RequestMethod.GET)
    public void writeExcel(HttpServletResponse response) throws IOException {
        System.out.println("Ali查询开始"+simpleDateFormat.format(new Date()));
        List<TbSellOrderVo> list = new ArrayList<>();
        TbSellOrderVo tbSellOrderVo = new TbSellOrderVo();
        String fileName = "一个Excel文件";
        String sheetName = "第一个sheet";
        TbSellOrderExample example = new TbSellOrderExample();
        List<TbSellOrder> tbSellOrderList = tbSellOrderMapper.selectByExample(example);
        for (TbSellOrder tbSellOrder : tbSellOrderList) {
            BeanUtils.copyProperties(tbSellOrder,tbSellOrderVo);
            list.add(tbSellOrderVo);
        }
        System.out.println("Ali开始"+simpleDateFormat.format(new Date()));
        ExcelUtil.writeExcel(response, list, fileName, sheetName, new TbSellOrderVo());
        System.out.println("Ali结束"+simpleDateFormat.format(new Date()));
    }

    /**
     * 导出 批次指标各阶段数据统计
     * easypoi的多表头导出
     * */
    @RequestMapping(value = "/exportEasyPoi", method = RequestMethod.GET)
    public void exportEasyPoi(HttpServletResponse response) {
        System.out.println("poi查询开始"+simpleDateFormat.format(new Date()));
        // 设置导出参数
        List<TbSellOrderPoiVo> list = new ArrayList<>();
        TbSellOrderPoiVo tbSellOrderPoiVo = new TbSellOrderPoiVo();
        try {
            List<TbSellOrder> tbSellOrderList = tbSellOrderMapper.selectByExample(new TbSellOrderExample());
            for (TbSellOrder tbSellOrder : tbSellOrderList) {
                BeanUtils.copyProperties(tbSellOrder,tbSellOrderPoiVo);
                list.add(tbSellOrderPoiVo);
            }
            //导出操作
            System.out.println("poi开始"+simpleDateFormat.format(new Date()));
            ExcelPoiUtil.exportExcel(list,null,"商品列表",
                    TbSellOrderPoiVo.class,"commodity_upload_template.xls",response);
            System.out.println("poi结束"+simpleDateFormat.format(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
