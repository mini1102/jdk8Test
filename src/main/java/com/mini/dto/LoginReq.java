package com.mini.dto;

import lombok.Data;

@Data
public class LoginReq extends BaseDTO{
    private Long id;
    private String name;

    public LoginReq(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
