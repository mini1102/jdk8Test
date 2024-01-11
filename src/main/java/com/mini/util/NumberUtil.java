package com.mini.util;

import java.math.BigInteger;

public class NumberUtil {
    public static Long add(Long a, Long b) {
        BigInteger num1 = new BigInteger(a+"");
        BigInteger num2 = new BigInteger(b+"");
        return num1.add(num2).longValue();
    }
}
