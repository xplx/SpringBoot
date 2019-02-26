package com.example.springbootexcel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wuxiaopeng
 */
public class TbSellOrderVo extends BaseRowModel {
    @ExcelProperty(value = "id", index = 0)
    private Long id;

    @ExcelProperty(value = "订单号", index = 1)
    private String sellorderNo;

    @ExcelProperty(value = "总价", index = 2)
    private BigDecimal totalPrice;

    @ExcelProperty(value = "优惠总价", index = 3)
    private BigDecimal integralAmount;

    @ExcelProperty(value = "支付总额", index = 4)
    private BigDecimal paidAmoun;

    @ExcelProperty(value = "找零", index = 5)
    private BigDecimal collection;

    @ExcelProperty(value = "支付方式", index = 6)
    private Integer payWay;

    @ExcelProperty(value = "订单方式", index = 7)
    private Integer sellorderType;

    @ExcelProperty(value = "支付状态", index =8)
    private Integer paymentStatus;

    @ExcelProperty(value = "订单状态", index = 9)
    private Integer sellorderStatus;

    @ExcelProperty(value = "购买id", index = 10)
    private Long buyId;

    @ExcelProperty(value = "店铺id", index = 11)
    private Long shopId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellorderNo() {
        return sellorderNo;
    }

    public void setSellorderNo(String sellorderNo) {
        this.sellorderNo = sellorderNo;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getIntegralAmount() {
        return integralAmount;
    }

    public void setIntegralAmount(BigDecimal integralAmount) {
        this.integralAmount = integralAmount;
    }

    public BigDecimal getPaidAmoun() {
        return paidAmoun;
    }

    public void setPaidAmoun(BigDecimal paidAmoun) {
        this.paidAmoun = paidAmoun;
    }

    public BigDecimal getCollection() {
        return collection;
    }

    public void setCollection(BigDecimal collection) {
        this.collection = collection;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Integer getSellorderType() {
        return sellorderType;
    }

    public void setSellorderType(Integer sellorderType) {
        this.sellorderType = sellorderType;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getSellorderStatus() {
        return sellorderStatus;
    }

    public void setSellorderStatus(Integer sellorderStatus) {
        this.sellorderStatus = sellorderStatus;
    }

    public Long getBuyId() {
        return buyId;
    }

    public void setBuyId(Long buyId) {
        this.buyId = buyId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "TbSellOrderVo{" +
                "id=" + id +
                ", sellorderNo='" + sellorderNo + '\'' +
                ", totalPrice=" + totalPrice +
                ", integralAmount=" + integralAmount +
                ", paidAmoun=" + paidAmoun +
                ", collection=" + collection +
                ", payWay=" + payWay +
                ", sellorderType=" + sellorderType +
                ", paymentStatus=" + paymentStatus +
                ", sellorderStatus=" + sellorderStatus +
                ", buyId=" + buyId +
                ", shopId=" + shopId +
                '}';
    }
}