package com.mini.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SensitiveUtils {
    public static String xx(String withdrawName) {
        //银行卡号
        String regex = "(\\w{4})(.*)(\\w{4})";
        Matcher m = Pattern.compile(regex).matcher(withdrawName);
        if (m.find()) {
            String rep = m.group(2);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < rep.length(); i++) {
                sb.append("*");
            }
            return withdrawName.replaceAll(rep, sb.toString());
        }
        return null;
    }

    public static void main(String[] args) {
        String withdrawName = "6212262201023557228";
        System.out.println(xx(withdrawName));
    }
}
