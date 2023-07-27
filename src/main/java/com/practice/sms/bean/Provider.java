package com.practice.sms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * zyd 2023 07
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Provider {
    private Integer id;
    private String providerName;
    private String providerContact;
    private String contactPhone;
    private String providerAddress;
}
