package com.mini.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        // 假设有一个已知的日期字符串，如 "2024-04-11"
        String inputDate = "2024-04-11";

        // 使用 SimpleDateFormat 将字符串解析为 Date 对象
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(inputDate);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // 将 Date 转换为 LocalDate
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // 获取年、月、日信息
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);
    }
}
