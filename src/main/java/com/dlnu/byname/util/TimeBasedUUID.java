package com.dlnu.byname.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TimeBasedUUID {

    public static String generateCustomTimeBasedUUID() {
        // 获取当前时间戳并格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        String timestamp = sdf.format(new Date());

        // 生成随机数部分
        Random random = new Random();
        String randomPart = String.format("%08d", random.nextInt(10000));

        // 组合时间戳和随机数
        return timestamp + randomPart;
    }

    public static void main(String[] args) {
        String uuid = generateCustomTimeBasedUUID();
        System.out.println("Generated UUID: " + uuid);
    }
}



