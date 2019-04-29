package com.cecii.util;

import java.io.Serializable;
import java.util.List;

/**
 * @description 分页数据
 * @author slwu
 * @date 2019-。0-15
 */
public class PageInfo implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 3759632522769246221L;
	
	private Integer code;
	
	private String msg;
	
	private Integer count;
	
	private List data;
	
	public PageInfo() {};
	
	public PageInfo(com.github.pagehelper.PageInfo pageInfo) {
		this.code = 0;
		this.msg = "success";
		this.count = (int) pageInfo.getTotal();
		this.data = pageInfo.getList();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}
}
