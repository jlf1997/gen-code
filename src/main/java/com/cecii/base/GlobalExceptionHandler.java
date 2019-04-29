package com.cecii.base;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cimr.boot.comm.model.HttpResult;
import com.cimr.boot.exception.SysEnums;
import com.cimr.boot.utils.LogsUtil;

/**
 * @description 基础异常处理类
 * @author slwu
 * @date 2018-11-01
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	protected static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public HttpResult defaultErrorHandler(HttpServletRequest request, Exception ex) {
		HttpResult httpResult = new HttpResult();
		if(ex instanceof MethodArgumentNotValidException) {
			httpResult.setCode(SysEnums.ERROR_FORM_VALIDATE.getCode());
			httpResult.setMessage("参数校验异常");
			httpResult.setSuccess(false);
			return httpResult;
		}
		else {
			httpResult.setCode(SysEnums.API_ERROR.getCode());
			String msg = LogsUtil.getStackTrace(ex);
			logger.error(msg);
			httpResult.setMessage("接口异常"+msg);
			httpResult.setSuccess(false);
			return httpResult;
		}
	}
}
