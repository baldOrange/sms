package com.practice.sms.dao;

import com.practice.sms.bean.Vip;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zyd on 2021/4/24 22:24
 */
public interface VipMapper {

    /**
     * 查询所有会员信息并返回集合封装数据, 用于直接查询返回所有的商品信息
     * @return List
     */
    List<Vip> getAllVip();

    /**
     * 根据会员id获取该会员对象
     *
     * @param vipId 会员id
     * @return 会员对象
     */
    Vip getVipByVipId(Integer vipId);


    /**
     * 按照会员id修改会员信息
     *
     * @param vip 表单数据封装成的Vip对象
     * @return 影响的行数
     */
    int updateVipByVipId(Vip vip);


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
     *
     * @param vipName 会员名称
     * @return Product集合
     */
    List<Vip> getVipByVipName(@Param("vipName") String vipName);




//    /**
//     * 用于搜索显示, 根据商品名称查询后显示
//     * @param productName 商品名称
//     * @return 单个Product实体
//     */
//    Product getProductByProductName(String productName);
//
//

////    List<Product> getProductsByProductGroup();
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
//    /**
//     * 根据商品的编号获取到该商品(用于结算服务)
//     *
//     * @param productId 商品的编号
//     * @return Product
//     */
//    Product getProductByProductIdForCheckService(Integer productId);
//



//
//    /**
//     * 更新id对应的商品库存
//     *
//     * @param productId 商品id
//     * @param saleCount 售出数量
//     * @return 影响行数
//     */
//    int updateProductStock(@Param("productId") Integer productId, @Param("saleCount") Integer saleCount);
//
//    /**
//     * 更新id对应的商品库存(PLUS)
//     *
//     * @param productId 商品id
//     * @param saleCount 售出数量
//     * @param stock 库存
//     * @return 影响行数
//     */
//    int updateProductStockPlus(@Param("productId") Integer productId,
//                               @Param("saleCount") Integer saleCount,
//                               @Param("stock") Integer stock);
}
