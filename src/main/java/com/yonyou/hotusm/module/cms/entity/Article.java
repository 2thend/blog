package com.yonyou.hotusm.module.cms.entity;

import org.hibernate.validator.constraints.NotEmpty;

import com.yonyou.hotusm.common.persistence.DataEntity;

public class Article extends DataEntity<Article>{
	
	public static String ARTICLE_NEW="new:article";
	public static String ARTICLE="article";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String title;	//����
	
	private String image;	//ͼƬ
	private String keywords; //�ؼ���
	private Integer hits; //�����
	@NotEmpty
	private String type;//���µ����� �����»��и�������
	
	private ArticleData articleData; //���¸���
	private Category category; //�����ķ���
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public ArticleData getArticleData() {
		return articleData;
	}
	public void setArticleData(ArticleData articleData) {
		this.articleData = articleData;
	}
	@Override
	public String toString() {
		return this.title;
	}
	
}
