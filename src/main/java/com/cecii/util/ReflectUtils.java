package com.cecii.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * @description 反射util
 * @author slwu
 * @date 2019-01-29
 */
public class ReflectUtils {

	/**
	 * @description 获取不能空的属性
	 * @param obj
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Map<String, String> notEmptyField(Object obj) throws IllegalArgumentException, IllegalAccessException{
		Map<String, String> param = new HashMap<String, String>();
		Class<?> class_obj = obj.getClass();
		Field[] fields = class_obj.getDeclaredFields();
		for(Field field : fields) {
			//设置可访问
			field.setAccessible(true);
			Object value = field.get(obj);
			if(null != value && !StringUtils.isEmpty(value.toString())) {
				param.put(field.getName(), value.toString());
			}
		}
		return param;
	} 

}