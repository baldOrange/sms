package com.practice.sms.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws ParseException {
        String s = "1662460000000";
        //设置时间的格式
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将时间转换指定格式的日期
        String date = f.format(Long.parseLong(s));
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        Date times = f.parse(date);
        calendar.setTime(times);
        calendar.add(Calendar.YEAR, -1);
        System.out.println(calendar.getTime());
    }
}
