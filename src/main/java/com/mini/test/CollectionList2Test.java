package com.mini.test;

import com.alibaba.fastjson.JSON;
import com.mini.dto.ReconDetail;
import com.mini.util.NumberUtil;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CollectionList2Test {
    public static void main(String[] args) {
        List<ReconDetail> list = buildReconDetailList();
        ReconDetail detail = list.stream().reduce((x, y) -> new ReconDetail
                (
                        NumberUtil.add(x.getSrcQty(), y.getSrcQty()),
                        (x.getSrcAmt().add(y.getSrcAmt())),
                        NumberUtil.add(x.getOppQty(), x.getOppQty()),
                        (x.getOppAmt().add(x.getOppAmt()))
                )).orElse(new ReconDetail(0L, new BigDecimal("0"), 0L, new BigDecimal("0")));
        System.out.println(JSON.toJSONString(detail));
    }

    private static List<ReconDetail> buildReconDetailList() {
        List<ReconDetail> list = Arrays.asList(
                new ReconDetail(1L, 1L, new BigDecimal("1.1"), 10L, new BigDecimal("11")),
                new ReconDetail(2L, 2L, new BigDecimal("1.2"), 20L, new BigDecimal("21")),
                new ReconDetail(3L, 3L, new BigDecimal("1.3"), 30L, new BigDecimal("31")),
                new ReconDetail(4L, 4L, new BigDecimal("1.4"), 40L, new BigDecimal("41")),
                new ReconDetail(5L, 5L, new BigDecimal("1.5"), 50L, new BigDecimal("51")),
                new ReconDetail(6L, 6L, new BigDecimal("1.6"), 60L, new BigDecimal("61")),
                new ReconDetail(7L, 7L, new BigDecimal("1.7"), 70L, new BigDecimal("71")),
                new ReconDetail(8L, 8L, new BigDecimal("1.8"), 80L, new BigDecimal("81"))
        );
        return list;
    }
}
