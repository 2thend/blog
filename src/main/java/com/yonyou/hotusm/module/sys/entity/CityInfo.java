package com.yonyou.hotusm.module.sys.entity;
/**
 * ���������Ϣ
 * @author Hotusm
 *
 */
public class CityInfo {
	
	private String code;	//����
	private Data data;		//���е���ϸ��Ϣ
	
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
