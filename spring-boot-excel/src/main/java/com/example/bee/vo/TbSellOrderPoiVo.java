package com.example.bee.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class TbSellOrderPoiVo implements Serializable {
    @Excel(name = "id")
    private Long id;

    @Excel(name = "订单号")
    private String sellorderNo;

    @Excel(name = "订单号")
    private BigDecimal totalPrice;

    @Excel(name = "订单号")
    private BigDecimal integralAmount;

    @Excel(name = "订单号")
    private BigDecimal paidAmoun;

    @Excel(name = "订单号")
    private BigDecimal collection;

    @Excel(name = "订单号")
    private BigDecimal change;

    @Excel(name = "订单号")
    private Integer payWay;

    @Excel(name = "订单号")
    private Integer sellorderType;

    @Excel(name = "订单号")
    private Integer paymentStatus;

    @Excel(name = "订单号")
    private Integer sellorderStatus;

    @Excel(name = "订单号")
    private Long buyId;

    @Excel(name = "订单号")
    private Long shopId;
}