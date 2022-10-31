package com.mini;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionMapTest {
    public static void main(String[] args) {
      /*  Map<String, List<Student>> studentMap = buildStudentMap();
        List<Student> collect1 = studentMap.values().stream().flatMap(a -> a.stream()).collect(Collectors.toList());

        List<Student> collect = collect1;
        collect.forEach(System.out::println);*/
       /* final List<List<Student>> collect = studentMap.values().stream().collect(Collectors.toList());
        collect.forEach(System.out::println);*/

        List<Student> studentList = buildStudentList();
       /* Map<Long, Student> collect = studentList.stream().collect(Collectors.toMap(a -> a.getId(), a -> a));
        collect.forEach((k,v) -> System.out.println(k+":"+v));*/

        List<String> nameList = studentList.stream().map(Student::getName).distinct().collect(Collectors.toList());
        nameList.forEach(item -> System.out.println(item));
    }

    private static Map<String, List<Student>> buildStudentMap() {
        List<Student> studentList = buildStudentList();
        // 根据摸个字段分组
        Map<String, List<Student>> studentMap = studentList.stream().collect(Collectors.groupingBy(a-> a.getName() ));
        return studentMap;
    }

    private static List<Student> buildStudentList() {
        List<Student> list = Arrays.asList(
                new Student(1L,"zhangsan", "男", 20, "语文",85),
                new Student(2L,"zhangsan", "男", 20, "数学",82),
                new Student(3L,"zhangsan", "女", 20, "英语",84),
                new Student(4L,"lisi", "男", 18, "语文",90),
                new Student(5L,"lisi", "男", 18, "数学",92),
                new Student(6L,"lisi", "男", 18, "英语",91),
                new Student(7L,"wangwu", "女", 31, "语文",75),
                new Student(8L,"wangwu", "女", 31, "数学",76),
                new Student(9L,"wangwu", "女", 31, "英语",77),
                new Student(10L,"zhaoliu", "男", 22, "语文",60),
                new Student(11L,"zhaoliu", "男", 22, "数学",63),
                new Student(12L,"zhaoliu", "男", 22, "英语",61),
                new Student(13L,"hejiong", "男", 47, "语文",98),
                new Student(14L,"hejiong", "男", 47, "数学",100),
                new Student(15L,"hejiong", "男", 47, "英语",99),
                new Student(16L,"xiena", "女", 41, "语文",35),
                new Student(17L,"xiena", "女", 41, "数学",45),
                new Student(18L,"xiena", "女", 41, "英语",37)
        );

        return list;
    }
}
