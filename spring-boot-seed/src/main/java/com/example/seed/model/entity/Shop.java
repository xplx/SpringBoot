package com.example.seed.model.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id")
    private Integer id;

    @Column(name = "shop_id")
    @ApiModelProperty("门店id")
    private Integer shopId;

    @Column(name = "name")
    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("创建日期")
    private Date creationDate;

    @ApiModelProperty("年龄")
    private Integer age;
}