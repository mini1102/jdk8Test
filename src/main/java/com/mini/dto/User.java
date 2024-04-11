package com.mini.dto;

import lombok.Data;
@Data
public class User extends BaseDTO{
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
