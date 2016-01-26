package com.yonyou.hotusm.module.sys.entity;
/**
 * 保存城市信息
 * @author Hotusm
 *
 */
public class CityInfo {
	
	private String code;	//编码
	private Data data;		//城市的详细信息
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Entity [code=" + code + ", data=" + data + "]";
	}
	
	
}
