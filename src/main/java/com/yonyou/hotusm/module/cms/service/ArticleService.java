package com.yonyou.hotusm.module.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.yonyou.hotusm.common.mapper.JsonMapper;
import com.yonyou.hotusm.module.cms.dao.ArticleDao;
import com.yonyou.hotusm.module.cms.dao.ArticleDataDao;
import com.yonyou.hotusm.module.cms.entity.Article;
import com.yonyou.hotusm.module.cms.entity.ArticleData;
import com.yonyou.hotusm.module.nosql.redis.JedisTemplate;
import com.yonyou.hotusm.module.sys.dao.UserDao;
import com.yonyou.hotusm.module.sys.entity.User;
import com.yonyou.hotusm.module.sys.util.UserUtils;

@Service
public class ArticleService{
	
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private ArticleDataDao articleDateDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private JedisTemplate jedisTemplate;
	@Transactional(readOnly=true)
	public void save(Article article){
		if(article==null){
			return;
		}
		article.preInsert();
		ArticleData ad=article.getArticleData();
		if(ad!=null){
			ad.preInsert();
			article.setArticleData(ad);
			articleDateDao.insert(ad);
		}
		//将最新的博客存放到缓存中
		articleDao.insert(article);
	}
	public List<Article> findArticleByUser(User user){
		if(user==null){
			user=UserUtils.getUser();
		}
		Article article=new Article();
		article.setCreateBy(user);
		List<Article> articles=articleDao.findList(article);
		if(articles==null){
			articles=Lists.newArrayList();
		}
		return articles;
	}
	/**
	 * 根据文章的id获取文章的具体内容
	 * @param article
	 * @return
	 */
	public Article getArticle(Article article){
		String jsonString=jedisTemplate.get("article:"+article.getId());
		Article a=(Article) JsonMapper.fromJsonString(jsonString, Article.class);
		if(a==null){
			Article temp=articleDao.get(article);
			if(temp==null){
				return new Article();
			}
			jedisTemplate.set("article:"+temp.getId(), JsonMapper.toJsonString(temp));
		}
		return a;
	}
	public Article getHotArticle(){
		jedisTemplate.lrange("new:article", 0,-1);
		return null;
	}
	
	/**
	 * 获取最新文章的列表
	 * @param start 开始位置
	 * @param end   结束的位置
	 * @return		
	 */
	public List<Article> getNewArticle(long start,long end){
		List<String> articleString=jedisTemplate.lrange("new:article", 0,-1);
		List<Article> articles=Lists.newArrayList();
		if(articleString==null){
			
		}else{	
			Article a=null;
			for(String str:articleString){
				a=new Article();
				a=(Article) JsonMapper.fromJsonString(str, Article.class);
				articles.add(a);
			}
		}
		
		return articles;
	}

}
