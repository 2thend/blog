package com.yonyou.hotusm.module.cms.entity;

import com.yonyou.hotusm.common.persistence.DataEntity;

public class ArticleData extends DataEntity<ArticleData>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2154587610433404107L;
	
	private String content;
	private Article article;
	private String allowComment;//�Ƿ��������� Ŀǰȫ��Ϊ��������
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public String getAllowComment() {
		return allowComment;
	}
	public void setAllowComment(String allowComment) {
		this.allowComment = allowComment;
	}
	
	@Override
	public String toString() {
		return this.article.getTitle();
	}
	
}
