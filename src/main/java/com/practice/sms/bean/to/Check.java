package com.practice.sms.bean.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用于结算服务显示的TO
 *
 * @author zyd on 2023/5/2 1:10
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Check {
    // 商品id
    private Integer productId;
    // 商品名称
    private String productName;
    // 销售单价
    private float productSalePrice;
    // 购买数量
    private Integer productNumber;
    // 应付金额
    private float checkPrice;
}
