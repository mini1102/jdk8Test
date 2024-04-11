package com.mini.test;

import com.alibaba.fastjson.JSON;
import com.mini.dto.StdTransApplyOrder;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        StdTransApplyOrder applyOrder = new StdTransApplyOrder();
        applyOrder.setTransNo("STDTAP4030894753875264408");
        applyOrder.setOrderAmt(10000L);
        applyOrder.setOutTransNo("DW240226174838000000007315");

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("transNo", applyOrder.getTransNo());
        resultMap.put("amount",applyOrder.getOrderAmt());
        resultMap.put("outTransNo", applyOrder.getOutTransNo());
        System.out.println(JSON.toJSONString(resultMap));
    }
}
