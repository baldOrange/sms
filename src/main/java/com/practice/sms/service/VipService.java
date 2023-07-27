package com.practice.sms.service;

import com.practice.sms.bean.Vip;

import java.util.List;

/**
 * @author zyd on 2021/4/24 23:37
 */
public interface VipService {

    /**
     * 获取所有会员信息
     *
     * @return List集合
     */
    List<Vip> getAllVip();

    /**
     * 按照会员id修改会员信息
     *
     * @param vip 表单数据封装成的Vip对象
     * @return 影响的行数
     */
    int updateVipByVipId(Vip vip);

    /**
     * 根据会员id获取该会员对象
     *
     * @param vipId 会员id
     * @return 会员对象
     */
    Vip getVipByVipId(Integer vipId);

    /**
     * 按照会员id删除会员
     *
     * @param vipId 会员id
     * @return 影响的行数
     */
    int deleteVipByVipId(Integer vipId);

    /**
     * 新增会员信息
     *
     * @param vip vip
     * @return 影响的行数
     */
    int addVip(Vip vip);

    /**
     * 用于搜索显示, 根据会员名称查询后显示 ---> PLUS
     *      2021年4月30日01:44:36
     *
     * @param vipName 商品名称
     * @return Product集合
     */
    List<Vip> getVipByVipName(String vipName);

//    /**
//     * 用于搜索显示, 根据商品名称查询后显示
//     *
//     * @param productName 商品名称
//     * @return 单个Product实体
//     */
//    Product getProductByProductName(String productName);
//

//
//    /**
//     * 根据商品的编号获取到该商品的价格
//     *
//     * @param id 商品id
//     * @return 商品的价格
//     */
//    float getProductSalePriceByProductId(Integer id);
//



//
//    /**
//     * 根据商品id获取该商品对象
//     *
//     * @param productId 商品id
//     * @return 商品对象
//     */
//    Product getProductByProductId(Integer productId);
//
//

//


}
