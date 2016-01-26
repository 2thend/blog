package com.yonyou.hotusm.module.cms.dao;

import com.yonyou.hotusm.common.persistence.CrudDao;
import com.yonyou.hotusm.common.persistence.annoation.MyBatisDao;
import com.yonyou.hotusm.module.cms.entity.Article;

@MyBatisDao
public interface ArticleDao extends CrudDao<Article>{
	
}
