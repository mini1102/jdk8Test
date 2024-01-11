package com.mini.dto;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 */
public abstract class BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}