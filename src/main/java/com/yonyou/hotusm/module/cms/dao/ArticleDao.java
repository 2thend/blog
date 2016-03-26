package com.yonyou.hotusm.module.cms.dao;

import java.util.List;

import com.yonyou.hotusm.common.persistence.CrudDao;
import com.yonyou.hotusm.common.persistence.annoation.MyBatisDao;
import com.yonyou.hotusm.module.cms.entity.Article;

@MyBatisDao
public interface ArticleDao extends CrudDao<Article>{
	/**
	 * 获取最新的文章
	 * @return
	 */
	public List<Article> getNewArticles();
}
