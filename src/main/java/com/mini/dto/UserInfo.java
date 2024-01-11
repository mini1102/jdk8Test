package com.mini.dto;

import lombok.Data;

@Data
public class UserInfo extends BaseDTO{
    private Long id;
    private String mobile;
    private int age;

    public UserInfo(Long id, String mobile, int age) {
        this.id = id;
        this.mobile = mobile;
        this.age = age;
    }
}
