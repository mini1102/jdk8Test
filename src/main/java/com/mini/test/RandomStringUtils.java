package com.mini.test;

import com.mini.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RandomStringUtils {
    public static String generateRandomString(int length) {
        String chars = "0123456789";
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Set<Character> charSet = new HashSet<>();
        StringBuilder sb = new StringBuilder(length);

        while (charSet.size() < length) {
            char c = chars.charAt(random.nextInt(chars.length()));
            charSet.add(c);
            sb.append(c);
        }

        return sb.substring(0, length);
    }

    public static void main(String[] args) {

        //System.out.println(generateRandomString(9));

        System.out.println(generateTrustUnitName("A",1111L));
    }

    private static String generateTrustUnitName(String sharePrefix, Long customerId) {
        StringBuffer sb = new StringBuffer();
        sb.append(sharePrefix);
        sb.append("类信托财产份额");
        sb.append("_");
        sb.append(customerId);
        sb.append("_");
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");
        sb.append(formatter.format(new Date()));
        sb.append(getRandom());
        return sb.toString();
    }

    private static String getRandom() {
        // 创建Random对象
        Random random = new Random();
        // 生成0到999之间的随机数
        int randomNumber = random.nextInt(1000);
        // 使用String.format格式化为三位数，不足前面补0
        return String.format("%03d", randomNumber);
    }

}
