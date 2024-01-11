package com.mini.test;

import com.alibaba.fastjson.JSON;
import com.mini.dto.LoginReq;
import com.mini.dto.User;
import com.mini.dto.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionList3Test {
    public static void main(String[] args) {
        List<UserInfo> userInfoList = buildUserInfoList();
        List<LoginReq> reqList = buildLoginReqList();

         // 新增
        List<LoginReq> added = new ArrayList<>(reqList);
        added.removeIf(u -> userInfoList.stream().anyMatch(p -> u.getId().equals(p.getId())));
        System.out.println(JSON.toJSONString(added));
        //System.out.println(JSON.toJSONString(reqList));



        // 修改
        List<LoginReq> modified = reqList.stream()
                .filter(u -> userInfoList.stream().anyMatch(p -> u.getId().equals(p.getId())))
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(modified));
        //System.out.println(JSON.toJSONString(reqList));

        // 删除
        List<Long> removed = userInfoList.stream()
                .filter(u -> reqList.stream().noneMatch(p -> p.getId().equals(u.getId())))
                .map(UserInfo::getId)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(removed));
        //System.out.println(JSON.toJSONString(reqList));
    }

    private static List<UserInfo> buildUserInfoList() {
        List<UserInfo> list = new ArrayList<>();
        list.add(new UserInfo(1L, "111111", 1));
        list.add(new UserInfo(2L, "222222", 2));
        return list;
    }

    private static List<LoginReq> buildLoginReqList() {
        List<LoginReq> list = new ArrayList<>();
        list.add(new LoginReq(2L, "二二二二"));
        list.add(new LoginReq(3L, "三三三三"));
        list.add(new LoginReq(4L, "四四四四"));
        return list;
    }

}
