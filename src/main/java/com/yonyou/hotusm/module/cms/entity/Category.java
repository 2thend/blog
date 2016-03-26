package com.yonyou.hotusm.module.cms.entity;

import com.yonyou.hotusm.common.persistence.DataEntity;

public class Category extends DataEntity<Category>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7513324148637194499L;
	
	private String title;
	private String description;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return this.title;
	}
	public Category(String id,String title, String description) {
		super();
		setId(id);
		this.title = title;
		this.description = description;
	}
	public Category() {
		super();
	}
	
	
}
