package com.practice.sms.service;

import com.practice.sms.bean.to.ChecKoutSale;

import java.util.List;

/**
 * @author zyd on 2021/5/2 1:22
 */
public interface ChecKoutService {


    /**
     * 查询销售额
     *
     * @return TO集合
     */
    String getTransactionAmount();

    /**
     * 查询进货额
     *
     * @return TO集合
     */
    String getPurchaseAmount();

    /**
     * 用于根据条件展示销售信息
     *
     * @param groupId 商品分类信息
     * @param startDate 搜索开始时间
     * @param endDate 搜索结束时间
     * @return TO集合
     */
    List<ChecKoutSale> getSaleInfoByCondition(Integer groupId, String startDate, String endDate);



    Integer addProductSale(ChecKoutSale checKoutSale);

}
