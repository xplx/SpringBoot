package com.example.seed.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author wxp
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("门店id")
    private Integer shopId;

    @ApiModelProperty("门店名称")
    private String shopName;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("年龄")
    private String age;

    @ApiModelProperty("创建日期")
    private Date creationDate;
}