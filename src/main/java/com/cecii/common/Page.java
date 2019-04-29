package com.cecii.common;

import java.io.Serializable;

/**
 * @description 分页
 * @author slwu
 * @date 2018-01-30
 */
public class Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4804556454377270655L;
	
	private Integer pageNo;
	
	private Integer pageSize;
	
	private Long total;
	
	private Integer pages;
	
	private Object list;

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}
	
	
}
