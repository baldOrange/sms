package com.practice.sms.service;

import com.practice.sms.bean.to.Sale;

import java.util.List;

/**
 * @author zyd on 2021/5/2 1:22
 */
public interface SaleService {

    /**
     * 增加一条销售记录
     *
     * @param productId 售出商品id
     * @param saleCount 售出数量
     * @return 影响的行数
     */
    int insertSaleItem(Integer productId, Integer saleCount);

    /**
     * 用于根据条件展示销售信息
     *
     * @param groupId 商品分类信息
     * @param startDate 搜索开始时间
     * @param endDate 搜索结束时间
     * @return TO集合
     */
    List<Sale> getSaleInfoByCondition(Integer groupId, String startDate, String endDate);
}
