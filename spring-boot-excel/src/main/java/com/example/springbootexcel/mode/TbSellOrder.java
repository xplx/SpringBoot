package com.example.springbootexcel.mode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbSellOrder implements Serializable {
    private Long id;

    private String sellorderNo;

    private BigDecimal totalPrice;

    private BigDecimal integralAmount;

    private BigDecimal paidAmoun;

    private BigDecimal collection;

    private BigDecimal change;

    private Integer payWay;

    private Integer sellorderType;

    private Integer paymentStatus;

    private Integer sellorderStatus;

    private Long buyId;

    private Long shopId;

    private Long shophqId;

    private Long cashierId;

    private Date createTime;

    private Date updateTime;

    private BigDecimal empty;

    private BigDecimal orderPreferential;

    private BigDecimal memberPreferential;

    private Integer memberOrderType;

    private static final long serialVersionUID = 1L;

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
        this.sellorderNo = sellorderNo == null ? null : sellorderNo.trim();
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

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
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

    public Long getShophqId() {
        return shophqId;
    }

    public void setShophqId(Long shophqId) {
        this.shophqId = shophqId;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getEmpty() {
        return empty;
    }

    public void setEmpty(BigDecimal empty) {
        this.empty = empty;
    }

    public BigDecimal getOrderPreferential() {
        return orderPreferential;
    }

    public void setOrderPreferential(BigDecimal orderPreferential) {
        this.orderPreferential = orderPreferential;
    }

    public BigDecimal getMemberPreferential() {
        return memberPreferential;
    }

    public void setMemberPreferential(BigDecimal memberPreferential) {
        this.memberPreferential = memberPreferential;
    }

    public Integer getMemberOrderType() {
        return memberOrderType;
    }

    public void setMemberOrderType(Integer memberOrderType) {
        this.memberOrderType = memberOrderType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sellorderNo=").append(sellorderNo);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", integralAmount=").append(integralAmount);
        sb.append(", paidAmoun=").append(paidAmoun);
        sb.append(", collection=").append(collection);
        sb.append(", change=").append(change);
        sb.append(", payWay=").append(payWay);
        sb.append(", sellorderType=").append(sellorderType);
        sb.append(", paymentStatus=").append(paymentStatus);
        sb.append(", sellorderStatus=").append(sellorderStatus);
        sb.append(", buyId=").append(buyId);
        sb.append(", shopId=").append(shopId);
        sb.append(", shophqId=").append(shophqId);
        sb.append(", cashierId=").append(cashierId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", empty=").append(empty);
        sb.append(", orderPreferential=").append(orderPreferential);
        sb.append(", memberPreferential=").append(memberPreferential);
        sb.append(", memberOrderType=").append(memberOrderType);
        sb.append("]");
        return sb.toString();
    }
}