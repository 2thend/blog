package com.yonyou.hotusm.common.persistence.interceptor;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.yonyou.hotusm.common.mapper.JsonMapper;
import com.yonyou.hotusm.module.cms.entity.Article;
import com.yonyou.hotusm.module.nosql.redis.JedisTemplate;


/**
 * ���·����Ժ�����
 * 
 * @author Hotusm
 *
 */
@Aspect
public class ValidateArticlAspect {
	
	@Autowired
	private JedisTemplate jedisTemplate;

	/**
	 * ���·���֮����֤��Ϣ,���ҷ��뻺��
	 */
	@After(value="execution(* com.yonyou.hotusm.module.cms.service.ArticleService.save(..))&&args(article)",argNames="article")
	public void afterPublish(Object object){
		if(object instanceof Article){
			Article article=(Article) object;
			
			if(article.getIsNewRecord()!=1){
				//�����·��뵽����������
				jedisTemplate.lpush(Article.ARTICLE_NEW, JsonMapper.toJsonString(article));
				
				//��ƪ������ϸ��Ϣ
				jedisTemplate.set(Article.ARTICLE+article.getId(), JsonMapper.toJsonString(article));
			}
			
		}
		
		
	}
	
	
}
