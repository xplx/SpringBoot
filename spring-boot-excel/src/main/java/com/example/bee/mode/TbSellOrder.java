package com.example.bee.mode;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * tb_sell_order 2019-04-08
 */
public class TbSellOrder implements Serializable {
    /**
     * 订单id
     */
    @ApiModelProperty(value = "订单id")
    @NotNull(message="订单id不能为空")
    private Long id;

    /**
     * 订单号
     */
    @ApiModelProperty(value = "订单号")
    @NotNull(message="订单号不能为空")
    private String sellorderNo;

    /**
     * 订单金额
     */
    @ApiModelProperty(value = "订单金额")
    private BigDecimal totalPrice;

    /**
     * 积分抵消金额
     */
    @ApiModelProperty(value = "积分抵消金额")
    private BigDecimal integralAmount;

    /**
     * 实收金额
     */
    @ApiModelProperty(value = "实收金额")
    private BigDecimal paidAmoun;

    /**
     * 实付
     */
    @ApiModelProperty(value = "实付")
    private BigDecimal collection;

    /**
     * 支付方式:1.现金，2.微信，3.支付宝,4.pos,-1 手机支付（不明确具体支付）, -2 未支付
     */
    @ApiModelProperty(value = "支付方式:1.现金，2.微信，3.支付宝,4.pos,-1 手机支付（不明确具体支付）, -2 未支付")
    private Integer payWay;

    /**
     * 订单类型1.线下订单，2.线上订单
     */
    @ApiModelProperty(value = "订单类型1.线下订单，2.线上订单")
    private Integer sellorderType;

    /**
     * 支付状态1.未支付，2.已支付
     */
    @ApiModelProperty(value = "支付状态1.未支付，2.已支付")
    private Integer paymentStatus;

    /**
     * 订单状态：  1:待付款2：已完成，3：已取消，4：已关闭, 5:发生退款
     */
    @ApiModelProperty(value = "订单状态：  1:待付款2：已完成，3：已取消，4：已关闭, 5:发生退款")
    private Integer sellorderStatus;

    /**
     * 买家ID
     */
    @ApiModelProperty(value = "买家ID")
    private Long buyId;

    /**
     * 店铺ID
     */
    @ApiModelProperty(value = "店铺ID")
    private Long shopId;

    /**
     * 总店ID
     */
    @ApiModelProperty(value = "总店ID")
    private Long shophqId;

    /**
     * 收银员Id
     */
    @ApiModelProperty(value = "收银员Id")
    private Long cashierId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 抹零
     */
    @ApiModelProperty(value = "抹零")
    private BigDecimal empty;

    /**
     * 整单优惠
     */
    @ApiModelProperty(value = "整单优惠")
    private BigDecimal orderPreferential;

    /**
     * 会员优惠
     */
    @ApiModelProperty(value = "会员优惠")
    private BigDecimal memberPreferential;

    /**
     * 会员订单类型：0、其他 1、会员订单
     */
    @ApiModelProperty(value = "会员订单类型：0、其他 1、会员订单")
    private Integer memberOrderType;

    /**
     * tb_sell_order
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取订单id
     * @return id 订单id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置订单id
     * @param id 订单id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取订单号
     * @return sellOrder_no 订单号
     */
    public String getSellorderNo() {
        return sellorderNo;
    }

    /**
     * 设置订单号
     * @param sellorderNo 订单号
     */
    public void setSellorderNo(String sellorderNo) {
        this.sellorderNo = sellorderNo == null ? null : sellorderNo.trim();
    }

    /**
     * 获取订单金额
     * @return total_price 订单金额
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置订单金额
     * @param totalPrice 订单金额
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取积分抵消金额
     * @return integral_amount 积分抵消金额
     */
    public BigDecimal getIntegralAmount() {
        return integralAmount;
    }

    /**
     * 设置积分抵消金额
     * @param integralAmount 积分抵消金额
     */
    public void setIntegralAmount(BigDecimal integralAmount) {
        this.integralAmount = integralAmount;
    }

    /**
     * 获取实收金额
     * @return paid_amoun 实收金额
     */
    public BigDecimal getPaidAmoun() {
        return paidAmoun;
    }

    /**
     * 设置实收金额
     * @param paidAmoun 实收金额
     */
    public void setPaidAmoun(BigDecimal paidAmoun) {
        this.paidAmoun = paidAmoun;
    }

    /**
     * 获取实付
     * @return collection 实付
     */
    public BigDecimal getCollection() {
        return collection;
    }

    /**
     * 设置实付
     * @param collection 实付
     */
    public void setCollection(BigDecimal collection) {
        this.collection = collection;
    }

    /**
     * 获取支付方式:1.现金，2.微信，3.支付宝,4.pos,-1 手机支付（不明确具体支付）, -2 未支付
     * @return pay_way 支付方式:1.现金，2.微信，3.支付宝,4.pos,-1 手机支付（不明确具体支付）, -2 未支付
     */
    public Integer getPayWay() {
        return payWay;
    }

    /**
     * 设置支付方式:1.现金，2.微信，3.支付宝,4.pos,-1 手机支付（不明确具体支付）, -2 未支付
     * @param payWay 支付方式:1.现金，2.微信，3.支付宝,4.pos,-1 手机支付（不明确具体支付）, -2 未支付
     */
    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    /**
     * 获取订单类型1.线下订单，2.线上订单
     * @return sellOrder_type 订单类型1.线下订单，2.线上订单
     */
    public Integer getSellorderType() {
        return sellorderType;
    }

    /**
     * 设置订单类型1.线下订单，2.线上订单
     * @param sellorderType 订单类型1.线下订单，2.线上订单
     */
    public void setSellorderType(Integer sellorderType) {
        this.sellorderType = sellorderType;
    }

    /**
     * 获取支付状态1.未支付，2.已支付
     * @return payment_status 支付状态1.未支付，2.已支付
     */
    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * 设置支付状态1.未支付，2.已支付
     * @param paymentStatus 支付状态1.未支付，2.已支付
     */
    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * 获取订单状态：  1:待付款2：已完成，3：已取消，4：已关闭, 5:发生退款
     * @return sellOrder_status 订单状态：  1:待付款2：已完成，3：已取消，4：已关闭, 5:发生退款
     */
    public Integer getSellorderStatus() {
        return sellorderStatus;
    }

    /**
     * 设置订单状态：  1:待付款2：已完成，3：已取消，4：已关闭, 5:发生退款
     * @param sellorderStatus 订单状态：  1:待付款2：已完成，3：已取消，4：已关闭, 5:发生退款
     */
    public void setSellorderStatus(Integer sellorderStatus) {
        this.sellorderStatus = sellorderStatus;
    }

    /**
     * 获取买家ID
     * @return buy_id 买家ID
     */
    public Long getBuyId() {
        return buyId;
    }

    /**
     * 设置买家ID
     * @param buyId 买家ID
     */
    public void setBuyId(Long buyId) {
        this.buyId = buyId;
    }

    /**
     * 获取店铺ID
     * @return shop_id 店铺ID
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * 设置店铺ID
     * @param shopId 店铺ID
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取总店ID
     * @return shopHq_id 总店ID
     */
    public Long getShophqId() {
        return shophqId;
    }

    /**
     * 设置总店ID
     * @param shophqId 总店ID
     */
    public void setShophqId(Long shophqId) {
        this.shophqId = shophqId;
    }

    /**
     * 获取收银员Id
     * @return cashier_id 收银员Id
     */
    public Long getCashierId() {
        return cashierId;
    }

    /**
     * 设置收银员Id
     * @param cashierId 收银员Id
     */
    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
    }

    /**
     * 获取创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取抹零
     * @return empty 抹零
     */
    public BigDecimal getEmpty() {
        return empty;
    }

    /**
     * 设置抹零
     * @param empty 抹零
     */
    public void setEmpty(BigDecimal empty) {
        this.empty = empty;
    }

    /**
     * 获取整单优惠
     * @return order_preferential 整单优惠
     */
    public BigDecimal getOrderPreferential() {
        return orderPreferential;
    }

    /**
     * 设置整单优惠
     * @param orderPreferential 整单优惠
     */
    public void setOrderPreferential(BigDecimal orderPreferential) {
        this.orderPreferential = orderPreferential;
    }

    /**
     * 获取会员优惠
     * @return member_preferential 会员优惠
     */
    public BigDecimal getMemberPreferential() {
        return memberPreferential;
    }

    /**
     * 设置会员优惠
     * @param memberPreferential 会员优惠
     */
    public void setMemberPreferential(BigDecimal memberPreferential) {
        this.memberPreferential = memberPreferential;
    }

    /**
     * 获取会员订单类型：0、其他 1、会员订单
     * @return member_order_type 会员订单类型：0、其他 1、会员订单
     */
    public Integer getMemberOrderType() {
        return memberOrderType;
    }

    /**
     * 设置会员订单类型：0、其他 1、会员订单
     * @param memberOrderType 会员订单类型：0、其他 1、会员订单
     */
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