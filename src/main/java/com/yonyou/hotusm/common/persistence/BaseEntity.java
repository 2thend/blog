package com.yonyou.hotusm.common.persistence;

import java.io.Serializable;

import com.yonyou.hotusm.common.utils.IdGen;

/**
 * @author Hotusm
 * ʵ���֧����
 *
 */
public abstract class BaseEntity<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6003875134842309882L;
	
	/**
	 * ʵ��id
	 */
	protected String id;
	/**
	 * �Ƿ����¼�¼ 1�������¼�¼0�������¼�¼
	 */
	protected int isNewRecord=0;
	
	public BaseEntity(){
		
	}
	
	public BaseEntity(String id){
		this.id=id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public int getIsNewRecord() {
		return isNewRecord;
	}

	public void setIsNewRecord(int isNewRecord) {
		this.isNewRecord = isNewRecord;
	}
	
	@Override
	public String toString() {
		return "id=" + id ;
	}
	

}
