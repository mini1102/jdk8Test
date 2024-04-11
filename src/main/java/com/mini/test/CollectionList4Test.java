package com.mini.test;

import com.alibaba.fastjson.JSON;
import com.mini.dto.Product;
import com.mini.dto.User;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionList4Test {
    public static void main(String[] args) {

        Set<Product> products = new HashSet<>(
                Arrays.asList(
                        new Product(1, "b"),
                        new Product(2, "c")
                )
        );

        List<User> users = Arrays.asList(
                new User(1, "a"),
                new User(3, "c"),
                new User(4, "d")
        );


// 新增
        List<User> added = products.stream()
                .filter(p -> users.stream().noneMatch(u -> u.getName().equals(p.getName())))
                .map(p -> new User(0, p.getName()))
                .collect(Collectors.toList());
        System.out.println("新增："+JSON.toJSONString(added));
// 修改
        List<User> modified = users.stream()
                .filter(u -> products.stream().anyMatch(p -> p.getName().equals(u.getName())))
                .collect(Collectors.toList());
        System.out.println("修改："+JSON.toJSONString(modified));
// 删除          
        List<User> removed = users.stream()
                .filter(u -> products.stream().noneMatch(p -> p.getName().equals(u.getName())))
                .collect(Collectors.toList());
        System.out.println("删除："+JSON.toJSONString(removed));

        // 删除
        List<String> removedNames = users.stream()
                .filter(u -> products.stream().noneMatch(p -> p.getName().equals(u.getName())))
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println("删除："+JSON.toJSONString(removedNames));

    }


}
