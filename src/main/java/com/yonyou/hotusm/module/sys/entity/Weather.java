package com.yonyou.hotusm.module.sys.entity;

/**
 * ����������vo
 * @author Hotusm
 *
 */
public class Weather {
	
	private String cityName;	//���е�λ��
	private String Tem;		//�¶ȷ�Χ
	private String data;		//�����Լ�״̬
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
