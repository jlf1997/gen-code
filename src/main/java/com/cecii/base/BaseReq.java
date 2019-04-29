package com.cecii.base;

import java.io.Serializable;

import com.cecii.common.Constants;

import io.swagger.annotations.ApiModelProperty;

public class BaseReq implements Serializable{

	/**
	 * 
	 */
	protected static final long serialVersionUID = 4535903891959141414L;
	
	@ApiModelProperty(value = "排序列", required = false)
	protected String orderColumn;
	
	@ApiModelProperty(value = "排序方式", required = false)
	protected String order = Constants.IS_DESC;
	
	@ApiModelProperty(value = "分页 pageNo", required = false)
	protected Integer pageNo = 1;
	
	@ApiModelProperty(value = "分页 pageSize", required = false)
	protected Integer pageSize = 10;
	
	

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

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	public String order() {
		return this.orderColumn + " " + this.order;
	}

	
	
}
