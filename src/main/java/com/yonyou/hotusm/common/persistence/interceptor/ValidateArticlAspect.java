package com.yonyou.hotusm.common.persistence.interceptor;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.yonyou.hotusm.common.mapper.JsonMapper;
import com.yonyou.hotusm.module.cms.entity.Article;
import com.yonyou.hotusm.module.nosql.redis.JedisTemplate;


/**
 * 文章发布以后切面
 * 
 * @author Hotusm
 *
 */
@Aspect
public class ValidateArticlAspect {
	
	@Autowired
	private JedisTemplate jedisTemplate;

	/**
	 * 文章发布之后验证信息,并且放入缓存
	 */
	@After(value="execution(* com.yonyou.hotusm.module.cms.service.ArticleService.save(..))&&args(article)",argNames="article")
	public void afterPublish(Object object){
		Article article=(Article) object;
		//将文章放入到最新文章中
		jedisTemplate.lpush(Article.ARTICLE_NEW, JsonMapper.toJsonString(article));
		
		//单篇文章详细信息
		jedisTemplate.set(Article.ARTICLE+article.getId(), JsonMapper.toJsonString(article));
	}
	
	
}
