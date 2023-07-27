package com.practice.sms.dao;

import com.practice.sms.bean.to.ChecKoutSale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 销售表Mapper
 *
 * @author zyd on 2023/5/2 1:10
 */
public interface ChecKoutMapper {


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
    List<ChecKoutSale> getSaleInfoByCondition(@Param("groupId") Integer groupId,
                                              @Param("startDate") String startDate,
                                              @Param("endDate") String endDate);





    Integer addProductSale(ChecKoutSale checKoutSale);



}