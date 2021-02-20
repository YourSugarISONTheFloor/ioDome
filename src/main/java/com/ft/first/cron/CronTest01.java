package com.ft.first.cron;


import com.ft.first.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Component
public class CronTest01 {

    @Autowired
    private RedisUtil redisUtil;

    @Scheduled(cron = "0 59 23 * * ? ")
    public void active_user_day() {
        Date date = new Date();
        //时间格式工厂
        SimpleDateFormat year_format = new SimpleDateFormat("yyyy-MM-dd");
        //将获取到的时间对象转为指定格式
        String day = year_format.format(date);
        System.out.println(day);
    }
}
