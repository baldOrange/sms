package com.practice.sms.service.impl;

import com.practice.sms.bean.to.ChecKoutSale;
import com.practice.sms.dao.ChecKoutMapper;
import com.practice.sms.service.ChecKoutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zyd on 2021/5/2 1:22
 */
@Service
public class ChecKoutServiceImpl implements ChecKoutService {
    @Resource
    private ChecKoutMapper checKoutMapper;

    @Override
    public String getTransactionAmount() {
        return checKoutMapper.getTransactionAmount();
    }

    @Override
    public String getPurchaseAmount() {
        return checKoutMapper.getPurchaseAmount();
    }

    @Override
    public List<ChecKoutSale> getSaleInfoByCondition(Integer groupId, String startDate, String endDate) {
        return checKoutMapper.getSaleInfoByCondition(groupId, startDate, endDate);
    }

    @Override
    public Integer addProductSale(ChecKoutSale checKoutSale) {
        return checKoutMapper.addProductSale(checKoutSale);
    }


}
