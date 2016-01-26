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
	private String title;	//标题
	
	private String image;	//图片
	private String keywords; //关键字
	private Integer hits; //点击数
	@NotEmpty
	private String type;//文章的类型 分类下还有各种类型
	
	private ArticleData articleData; //文章附表
	private Category category; //所属的分类
	
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
