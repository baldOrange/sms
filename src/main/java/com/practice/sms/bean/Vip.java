package com.practice.sms.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * @author zyd on 2021/4/24 22:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vip {
    private Integer id;
    private String vipName;
    private Double vipDiscount;
    private Date createDate;
}
