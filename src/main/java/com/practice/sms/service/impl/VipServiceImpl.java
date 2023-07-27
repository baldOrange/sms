package com.practice.sms.service.impl;

import com.practice.sms.bean.Vip;
import com.practice.sms.dao.VipMapper;
import com.practice.sms.service.VipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * zyd 2023 07
 */
@Service
public class VipServiceImpl implements VipService {
    @Resource
    private VipMapper vipMapper;

    @Override
    public List<Vip> getAllVip() {
        return vipMapper.getAllVip();
    }

    @Override
    public int updateVipByVipId(Vip vip) {
        return vipMapper.updateVipByVipId(vip);
    }

    @Override
    public Vip getVipByVipId(Integer vipId) {
        return vipMapper.getVipByVipId(vipId);
    }

    @Override
    public int deleteVipByVipId(Integer vipId) {
        return vipMapper.deleteVipByVipId(vipId);
    }

    @Override
    public int addVip(Vip vip) {
        return vipMapper.addVip(vip);
    }

//
@Override
public List<Vip> getVipByVipName(String vipName) {
    return vipMapper.getVipByVipName(vipName);
}



//    @Override
//    public Product getProductByProductName(String productName) {
//        return productMapper.getProductByProductName(productName);
//    }
//

//
//    @Override
//    public float getProductSalePriceByProductId(Integer id) {
//        return productMapper.getProductSalePriceByProductId(id);
//    }
//


//
//    @Override
//    @Deprecated
//    public int updateProductStock(Integer productId, Integer saleCount) {
//        return productMapper.updateProductStock(productId, saleCount);
//    }
//
//    @Override
//    public int updateProductStockPlus(Integer productId, Integer saleCount, Integer stock) {
//        return productMapper.updateProductStockPlus(productId, saleCount, stock);
//    }

}
