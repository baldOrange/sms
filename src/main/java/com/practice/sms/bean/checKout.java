package com.practice.sms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * zyd 2023 07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class checKout {
    private Integer id;
    private Integer groupId;
    // 2021年5月3日01:17:21新增, 用于records.jsp页面显示
    private Integer providerId;
    private String productName;
    private Date yieldDate;
    private String productFactory;
    private float purchasePrice;
    private Integer stock;
    private float salePrice;
    private Integer saleCount;
    private Date createDate;

    // 方便查询取值
    private Group group;
}
