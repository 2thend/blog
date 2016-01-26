package com.yonyou.hotusm.module.sys.entity;

/**
 * 保存天气的vo
 * @author Hotusm
 *
 */
public class Weather {
	
	private String cityName;	//城市的位置
	private String Tem;		//温度范围
	private String data;		//日期以及状态
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTem() {
		return Tem;
	}
	public void setTem(String tem) {
		Tem = tem;
	}
	
	
	
}
