package com.practice.sms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * zyd 2023 07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Group {
    private Integer id;
    private String groupName;

    // 新增属性, 一个商品类别下有很多商品
    private List<Product> products;
}
