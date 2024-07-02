package com.mini.test;

import cn.hutool.core.util.IdcardUtil;

public class HutoolTest {
    public static void main(String[] args) {
        String idNo="350424870506202";
        // idNo="22484219800101653X";
        idNo="320621199201106718";
        System.out.println(IdcardUtil.getBirthByIdCard(idNo));

        String province = IdcardUtil.getProvinceByIdCard(idNo);
        System.out.println(province);

        int gender = IdcardUtil.getGenderByIdCard(idNo);
        System.out.println(gender);
    }
}
