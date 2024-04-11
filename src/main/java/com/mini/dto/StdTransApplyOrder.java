package com.mini.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StdTransApplyOrder implements Serializable {
    private String transNo;
    private Long orderAmt;
    private String outTransNo;
}
