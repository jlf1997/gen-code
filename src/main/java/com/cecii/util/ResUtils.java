package com.cecii.util;

import com.cecii.common.Constants;
import com.cimr.boot.comm.model.HttpResult;

/**
 * @description 
 * @author slwu
 *
 */
public class ResUtils {

	public static HttpResult success(Integer code, Object data) {
		return ret(code, "success", data, true);
	}
	
	public static HttpResult success(Object data) {
		return ret(Integer.parseInt(Constants.SUCCESS), "success", data, true);
	}
	
	public static HttpResult error(Integer code, String msg) {
		return ret(code, msg, null, false);
	}
	
	public static HttpResult error(String msg) {
		return ret(Integer.parseInt(Constants.FAIL), msg, null, false);
	}
	
	public static HttpResult ret(Integer code, String message, Object data, boolean issuccess) {
		HttpResult httpResult = new HttpResult();
		httpResult.setCode(code);
		httpResult.setData(data);
		httpResult.setMessage(message);
		httpResult.setSuccess(issuccess);
		return httpResult;
	}
}
