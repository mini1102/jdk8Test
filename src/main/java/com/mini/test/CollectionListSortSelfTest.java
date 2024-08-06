package com.mini.test;

import com.alibaba.fastjson.JSON;
import com.mini.dto.Person;

import java.util.*;


public class CollectionListSortSelfTest {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        people.add(new Person("信托利益分配指令", 40));
        people.add(new Person("阿斯顿发士大夫购卡合同", 37));
        people.add(new Person("信托财产交付确认书", 39));
        people.add(new Person("服务信托项目信托合同", 36));
        people.add(new Person("信托单元设立及管理运作指令", 38));


        // 定义排序顺序
        List<String> sortOrder = Arrays.asList("Charlie", "Alice", "Bob", "购卡合同", "信托合同", "运作指令", "确认书", "分配指令");

        sortOrder.stream().forEach(s -> {
            people.stream().forEach(p -> {
                if (p.getName().contains(s)) {
                    p.setJiancheng(s);
                    return;
                }
            });
        });
        // 打印排序后的结果
        System.out.println("set jiancheng:");
        for (Person p : people) {
            System.out.println(JSON.toJSONString(p));
        }
        // 使用Comparator接口来实现排序
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int index1 = sortOrder.indexOf(o1.getJiancheng());
                int index2 = sortOrder.indexOf(o2.getJiancheng());
                // 如果没有找到对应的索引，则返回默认值（例如-1）
                if (index1 == -1) {
                    index1 = Integer.MAX_VALUE;
                }
                if (index2 == -1) {
                    index2 = Integer.MAX_VALUE;
                }
                return Integer.compare(index1, index2);
            }
        });

        // 打印排序后的结果
        System.out.println("Sorted names:");
        for (Person p : people) {
            System.out.println(JSON.toJSONString(p));
        }
    }
}
