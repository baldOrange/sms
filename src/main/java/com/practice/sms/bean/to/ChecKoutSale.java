package com.practice.sms.bean.to;

import com.practice.sms.bean.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author zyd on 2023/5/2 1:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChecKoutSale {
    // 商品id
    private Integer productId;
    // 购买数量
    private Integer productNumber;
    // 应付金额
    private float checkPrice;
    // 创建时间
    private Date generateTime;
    // 是否VIP
    private String isVip;
    // 用于展示单个商品信息的Product
    private Product product;
}
