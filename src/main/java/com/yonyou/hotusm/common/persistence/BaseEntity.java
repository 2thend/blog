package com.yonyou.hotusm.common.persistence;

import java.io.Serializable;

import com.yonyou.hotusm.common.utils.IdGen;

/**
 * @author Hotusm
 * 实体的支持类
 *
 */
public abstract class BaseEntity<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6003875134842309882L;
	
	/**
	 * 实体id
	 */
	protected String id;
	/**
	 * 是否是新记录 1代表不是新记录0代表是新记录
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
