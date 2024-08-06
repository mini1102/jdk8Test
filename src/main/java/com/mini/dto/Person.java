package com.mini.dto;

import lombok.Data;

@Data
public class Person  extends BaseDTO {
    String name;
    int age;
    String jiancheng;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
