package com.yonyou.hotusm.module.cms.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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
	/**
	 * 保存文章
	 * @param article
	 */
	@Transactional(readOnly=true)
	public void save(Article article){
		if(article==null){
			return;
		}
		if(article.getId()!=null){
			update(article);
			article.setIsNewRecord(1);
			jedisTemplate.del(Article.ARTICLE_NEW);
		}else{
			article.preInsert();
			ArticleData ad=article.getArticleData();
			if(ad!=null){
				ad.preInsert();
				article.setArticleData(ad);
				articleDateDao.insert(ad);
			}
			articleDao.insert(article);
		}
		
	}
	/**
	 * 显示所有的文章
	 * @param user
	 * @return
	 */
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
		String jsonString=jedisTemplate.get(Article.ARTICLE+article.getId());
		Article a=(Article) JsonMapper.fromJsonString(jsonString, Article.class);
		if(a==null){
			Article temp=articleDao.get(article);
			if(temp==null){
				return new Article();
			}
			jedisTemplate.set(Article.ARTICLE+temp.getId(), JsonMapper.toJsonString(temp));
		}
		return a;
	}
	/**
	 * 获得热门的文章
	 * @return
	 */
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
		List<String> articleString=jedisTemplate.lrange(Article.ARTICLE_NEW, 0,-1);
		List<Article> articles=Lists.newArrayList();
		if(articleString==null||articleString.size()<=0){
			// 如果是空的话,那么就直接从数据库中查询,并且放入到缓存中
			articles=articleDao.getNewArticles();
			for(Article article:articles){
				//从后面将数据重新插入
				jedisTemplate.rpush(Article.ARTICLE_NEW, JsonMapper.toJsonString(article));
			}
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
	/**
	 * 删除文章
	 */
	@Transactional(readOnly=false)
	public void delete(Article article){
		articleDao.delete(article);
	}
	/**
	 * 修改文章	
	 */
	@Transactional(readOnly=false)
	public void update(Article article){
		/**
		 * 修改人和修改时间
		 */
		article.setUpdateBy(UserUtils.getUser());
		article.setUpdateDate(new Date().toLocaleString());
		articleDao.update(article);
		ArticleData articleData = article.getArticleData();
		articleDateDao.update(articleData);
		jedisTemplate.set(Article.ARTICLE+article.getId(), JsonMapper.toJsonString(article));
	}
	
}
