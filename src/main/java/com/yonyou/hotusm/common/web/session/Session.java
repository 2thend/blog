package com.yonyou.hotusm.common.web.session;

import java.io.Serializable;
import java.util.Date;

public class Session implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Date createDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
