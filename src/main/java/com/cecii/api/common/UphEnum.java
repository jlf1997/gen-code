package com.cecii.api.common;

/**
 * @description uph类型
 * @author slwu
 * @date 2019-03-26
 */
public enum UphEnum {

	SPI(1, "spi"), AOI(2, "aoi");
	
	private Integer code;
	
	private String label;
	
	private UphEnum(Integer code, String label) {
		this.code = code;
		this.label = label;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public static UphEnum getObjByCode(Integer code) {
		for(UphEnum obj : values()) {
			if(code == obj.getCode()) {
				return obj;
			}
		}
		return null;
	}
}
