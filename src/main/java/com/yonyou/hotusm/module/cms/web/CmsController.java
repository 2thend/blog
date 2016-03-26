package com.yonyou.hotusm.module.cms.web;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yonyou.hotusm.common.web.BaseController;
import com.yonyou.hotusm.module.cms.entity.Article;
import com.yonyou.hotusm.module.cms.entity.ArticleData;
import com.yonyou.hotusm.module.cms.service.ArticleService;

@RequestMapping("/cms")
@Controller
public class CmsController extends BaseController{
	
	@Autowired
	private ArticleService articleService;
	
	@ModelAttribute
	public Article getArticle(@RequestParam(value="id",required=false) String id){
		Article article=new Article();
		if(id!=null){
			article.setId(id);
			return articleService.getArticle(article);
		}
		return article;
	}
	
	@RequestMapping("save")
	public String save(RedirectAttributes redirectAttributes,@Valid Article article,BindingResult result){
			//������ִ���Ļ������������ݵı���,���ҽ�������Ϣ����������ȥ
			if(result!=null&&result.getFieldErrors().size()>0){
				//do nothing
				redirectAttributes.addFlashAttribute("error", "���ⲻΪ��!");
			}else{
				article.setType("simple");
				articleService.save(article);
			}
			
		/**
		 * ���������༭ҳ��
		 */
		return "redirect:/a/article/sysManager";
	}
}
