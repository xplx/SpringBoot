package com.gzdsy.gogbee.bee.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * tb_commodity_price 2019-04-04
 */
public class TbCommodityPrice implements Serializable {
    /**
     * 
     */
    @ApiModelProperty(value = "")
    @NotNull(message="不能为空")
    private Integer id;

    /**
     * 商品ID
     */
    @ApiModelProperty(value = "商品ID")
    @NotNull(message="商品ID不能为空")
    private Integer commodityId;

    /**
     * 
     */
    @ApiModelProperty(value = "")
    private Integer receivableStyle;

    /**
     * 
     */
    @ApiModelProperty(value = "", example="0.0000")
    private BigDecimal receivablePrice;

    /**
     * Y=>删除
     */
    @ApiModelProperty(value = "Y=>删除", example="N")
    private String isDelete;

    /**
     * tb_commodity_price
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品ID
     * @return commodity_id 商品ID
     */
    public Integer getCommodityId() {
        return commodityId;
    }

    /**
     * 设置商品ID
     * @param commodityId 商品ID
     */
    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    /**
     * 获取
     * @return receivable_style 
     */
    public Integer getReceivableStyle() {
        return receivableStyle;
    }

    /**
     * 设置
     * @param receivableStyle 
     */
    public void setReceivableStyle(Integer receivableStyle) {
        this.receivableStyle = receivableStyle;
    }

    /**
     * 获取
     * @return receivable_price 
     */
    public BigDecimal getReceivablePrice() {
        return receivablePrice;
    }

    /**
     * 设置
     * @param receivablePrice 
     */
    public void setReceivablePrice(BigDecimal receivablePrice) {
        this.receivablePrice = receivablePrice;
    }

    /**
     * 获取Y=>删除
     * @return is_delete Y=>删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置Y=>删除
     * @param isDelete Y=>删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", commodityId=").append(commodityId);
        sb.append(", receivableStyle=").append(receivableStyle);
        sb.append(", receivablePrice=").append(receivablePrice);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}