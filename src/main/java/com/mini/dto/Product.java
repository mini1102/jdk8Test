package com.mini.dto;

import lombok.Data;

@Data
public class Product  extends BaseDTO{
    int pid;
    String name;

    public Product(int pid, String name) {
        this.pid = pid;
        this.name = name;
    }
}
