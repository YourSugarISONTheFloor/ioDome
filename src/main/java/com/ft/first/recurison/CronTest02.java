package com.ft.first.recurison;

import org.springframework.scheduling.annotation.Scheduled;

public class CronTest02 {
    public static void main(String[] args) {
//        // 验证cron定时表达式的正确性
//        String cron = "0/5 * * * * ?";
//        // 调用提供的API
//        boolean validExpression = CronExpression.isValidExpression(cron);
//        System.out.println(validExpression); // 表达式正确输出true、不正确则输出flase
    }

    @Scheduled(cron = "0/5 * * * * ?")//每5秒执行一次
    public void show(){
        System.out.println("5秒一次");
    }
}
