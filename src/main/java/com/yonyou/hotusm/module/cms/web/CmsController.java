package com.yonyou.hotusm.module.cms.web;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yonyou.hotusm.common.web.BaseController;
import com.yonyou.hotusm.module.cms.entity.Article;
import com.yonyou.hotusm.module.cms.entity.ArticleData;
import com.yonyou.hotusm.module.cms.service.ArticleService;

@RequestMapping("/cms")
@Controller
public class CmsController extends BaseController{
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("save")
	public String save(@Param("content") String content,Article article){
		ArticleData articleData=new ArticleData();
		articleData.setContent(content);
		article.setArticleData(articleData);
		article.setType("simple");
		articleService.save(article);
		return "redirect:/menu/sysManager";
	}
}
