package com.mini.test;


import com.mini.dto.Student;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionListTest {

    public static void main(String[] args) {
        List<Student> studentList = buildStudentList();
        studentList.forEach(System.out::println);
        /*// 根据摸个字段分组
        Map<Object, Map<Object, List<Student>>> map = studentList.stream().collect(Collectors.groupingBy(a-> a.getName(), Collectors.groupingBy(b->b.getSex()) ));
        map.forEach((k,v) -> v.forEach((k1,v1) -> v1.forEach(student -> System.out.println(k+"-"+k1+"-"+student)))
        );*/
        /*// 所有学生的平均成绩
        Double collect = studentList.stream().collect(Collectors.averagingInt(a -> a.getScore()));
        System.out.println(collect);*/
        // 每个学生的平均成绩
        final Map<String, Double> collect = studentList.stream().collect(Collectors.groupingBy(a ->
                a.getName(),
                TreeMap :: new,
                Collectors.averagingInt(b -> b.getScore())));
        //Optional.ofNullable(collect).ifPresent(System.out::println);
        collect.forEach((k,v)-> System.out.println(k+"-"+v));
        /*// 遍历赋值
        Stream<Student> list = studentList.stream().map(a -> {
            a.setCountry("中国");
            return a;
        });
        list.forEach(a-> System.out.println(a));*/


    }

    private static List<Student> buildStudentList() {
        List<Student> list = Arrays.asList(
                new Student("zhangsan", "男", 20, "语文",85),
                new Student("zhangsan", "男", 20, "数学",82),
                new Student("zhangsan", "女", 20, "英语",84),
                new Student("lisi", "男", 18, "语文",90),
                new Student("lisi", "男", 18, "数学",92),
                new Student("lisi", "男", 18, "英语",91),
                new Student("wangwu", "女", 31, "语文",75),
                new Student("wangwu", "女", 31, "数学",76),
                new Student("wangwu", "女", 31, "英语",77),
                new Student("zhaoliu", "男", 22, "语文",60),
                new Student("zhaoliu", "男", 22, "数学",63),
                new Student("zhaoliu", "男", 22, "英语",61),
                new Student("hejiong", "男", 47, "语文",98),
                new Student("hejiong", "男", 47, "数学",100),
                new Student("hejiong", "男", 47, "英语",99),
                new Student("xiena", "女", 41, "语文",35),
                new Student("xiena", "女", 41, "数学",45),
                new Student("xiena", "女", 41, "英语",37)
        );
        return list;
    }
}
