package com.mini.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss";

    public static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return sdf.parse(dateStr);
    }

    public static Date parseDateTime(String dateTimeStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
        return sdf.parse(dateTimeStr);
    }

    public static String formatDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return sdf.format(date);
    }

    public static String formatDateTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
        return sdf.format(date);
    }

    public static void xx(Date sourceDate, Date targetDate) {
        // java.util.Date转换成Instant类型
        Instant sourceInstant = sourceDate.toInstant();
        //将source时间转为年月日
        LocalDate sourceLocalDate = LocalDateTime.ofInstant(sourceInstant, ZoneId.systemDefault()).toLocalDate();
        // java.util.Date转换成Instant类型
        Instant targetInstant = targetDate.toInstant();
        //将targe时间转为年月日
        LocalDate targetLocalDate = LocalDateTime.ofInstant(targetInstant, ZoneId.systemDefault()).toLocalDate();
        //比较targe的时间在不在source时间之前
        if (targetLocalDate.compareTo(sourceLocalDate) == 0) {
            System.out.println("same");
        } else if (targetLocalDate.compareTo(sourceLocalDate) > 0) {
            System.out.println("目标时间大");
        }else {
            System.out.println("原时间大");
        }
    }


    public static void yy(LocalDateTime sourceDate, LocalDateTime targetDate) {
        //将source时间转为年月日
        LocalDate sourceLocalDate = sourceDate.toLocalDate();
        //将targe时间转为年月日
        LocalDate targetLocalDate = targetDate.toLocalDate();
        //比较targe的时间在不在source时间之前
        if (targetLocalDate.compareTo(sourceLocalDate) == 0) {
            System.out.println("same");
        } else if (targetLocalDate.compareTo(sourceLocalDate) > 0) {
            System.out.println("目标时间大");
        }else {
            System.out.println("原时间大");
        }
    }

    public static void main(String[] args) throws ParseException {
        /*Date sourceDate = parseDate("2021-09-29");
        Date targetDate = parseDateTime("2021-09-28 22:21:14");
        xx(sourceDate, targetDate);*/
        /*Date sourceDate = parseDateTime("2021-09-28 22:41:14");
        Date targetDate = parseDateTime("2021-09-27 22:21:14");
        // java.util.Date转换成Instant类型
        Instant sourceInstant = sourceDate.toInstant();
        //将source时间转为年月日
        LocalDateTime sourceLocalDate = LocalDateTime.ofInstant(sourceInstant, ZoneId.systemDefault());
        // java.util.Date转换成Instant类型
        Instant targetInstant = targetDate.toInstant();
        //将targe时间转为年月日
        LocalDateTime targetLocalDate = LocalDateTime.ofInstant(targetInstant, ZoneId.systemDefault());
        
        
        //yy(sourceLocalDate, targetLocalDate);

        Date currDate = new Date();
        // java.util.Date转换成Instant类型
        Instant currInstant = currDate.toInstant();
        //将source时间转为年月日
        LocalDateTime currLocalTime = LocalDateTime.ofInstant(currInstant, ZoneId.systemDefault());
        yy(currLocalTime, targetLocalDate);*/
        /*String endPayTime = "20211015141820";
        String day = endPayTime.substring(0,8);
        String hour = endPayTime.substring(8,10);
        String minuter= endPayTime.substring(10,12);
        System.out.println(day);
        System.out.println(hour);
        System.out.println(minuter);*/

        Date beginDate = parseDateTime("2021-10-12 09:41:14");
        Date endDate = parseDateTime("2021-10-17 10:21:14");
        LocalDateTime beginPayTime = dateToLocalDateTime(beginDate);
        LocalDateTime endPayTime = dateToLocalDateTime(endDate);
        System.out.println(judgeKindFlag(beginPayTime, endPayTime));
    }

    private static LocalDateTime dateToLocalDateTime(Date date) {
        // java.util.Date转换成Instant类型
        Instant dateInstant = date.toInstant();
        //将source时间转为年月日
        LocalDateTime localDateTime = LocalDateTime.ofInstant(dateInstant, ZoneId.systemDefault());
        return localDateTime;
    }

    /**
     * false：查未结流水，true：查已结流水
     * @param beginPayTime
     * @param endPayTime
     * @return
     */
    private static boolean judgeKindFlag(LocalDateTime beginPayTime, LocalDateTime endPayTime) {


        if(endPayTime.isBefore(beginPayTime)) {
            throw new RuntimeException("结束时间必须大于开始时间");
        }
        // 当前时间
        LocalDate currLocalDate = dateToLocalDateTime(new Date()).toLocalDate();
        //将begin时间转为年月日
        LocalDate beginLocalDate = beginPayTime.toLocalDate();
        //将end时间转为年月日
        LocalDate endLocalDate = endPayTime.toLocalDate();
        //比较targe的时间在不在source时间之前
        if (endLocalDate.compareTo(currLocalDate) > 0) {
            throw new RuntimeException("结束时间不能大于当前时间");
        }
        if (endLocalDate.compareTo(currLocalDate) == 0 && beginLocalDate.compareTo(currLocalDate) != 0) {
            throw new RuntimeException("结束时间与开始时间必须是当天，或者都不是当天");
        }
        boolean kindFlag = false;
        // 如果开始时间、结束时间是当天
        if (endLocalDate.compareTo(beginLocalDate) == 0 && endLocalDate.compareTo(currLocalDate) == 0) {
            kindFlag = false;
        } else if (endLocalDate.compareTo(currLocalDate) < 0) {
            kindFlag = true;
        }

        return kindFlag;
    }
}
