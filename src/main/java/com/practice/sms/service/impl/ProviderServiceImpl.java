package com.practice.sms.service.impl;

import com.practice.sms.bean.Product;
import com.practice.sms.bean.Provider;
import com.practice.sms.dao.ProviderMapper;
import com.practice.sms.service.ProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zyd on 2021/4/29 0:27
 */
@Service
public class ProviderServiceImpl implements ProviderService {
    @Resource
    private ProviderMapper providerMapper;

    @Override
    public List<Provider> getAllProviders() {
        return providerMapper.getAllProviders();
    }

    @Override
    public List<Product> getProviderRecordsByProviderId(Integer providerId) {
        return providerMapper.getProviderRecordsByProviderId(providerId);
    }

    @Override
    public Provider getProviderByProviderId(Integer providerId) {
        return providerMapper.getProviderByProviderId(providerId);
    }

    @Override
    public List<Provider> getProviderByProviderPhoneNumber(String phoneNumber) {
        return providerMapper.getProviderByProviderPhoneNumber(phoneNumber);
    }

    @Override
    public int deleteProviderByProviderId(Integer providerId) {
        return providerMapper.deleteProviderByProviderId(providerId);
    }

    @Override
    public int addProvider(Provider provider) {
        return providerMapper.addProvider(provider);
    }

    @Override
    public int updateProvider(Provider provider) {
        return providerMapper.updateProvider(provider);
    }
}
