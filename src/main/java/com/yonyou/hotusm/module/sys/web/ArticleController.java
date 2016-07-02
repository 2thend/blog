package com.yonyou.hotusm.module.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Lists;
import com.yonyou.hotusm.common.web.BaseController;
import com.yonyou.hotusm.module.cms.entity.Article;
import com.yonyou.hotusm.module.cms.entity.Category;
import com.yonyou.hotusm.module.cms.service.ArticleService;

@RequestMapping("${adminPath}/article")
@Controller
public class ArticleController extends BaseController{
	
	@Autowired
	private ArticleService articleService;
	
	/**
	 * 
	 * @ModelAttribute��ʹ�÷�ʽ:
	 * 1.��ע��ķ���,����ÿһ��Ŀ�귽��ִ��ǰ��springMVC�ȵ���ִ��
	 * 2.ִ������:
	 * 1).ִ��@ModelAttributeע�����εķ���(һ����ȡ������,���ҽ�������뵽ģ����)
	 * 2).SpringMVC��ģ����ȡ������,���ҽ��������������ֵ���ö������Ӧ������
	 * 3).SpringMVC�ٽ������Ķ����뵽Ŀ�귽���Ĳ�����
	 * 4).ע��:
		��.����ļ�����������ĸСд������,�����(key)�����,��ô���ܹ�������ֵ���뵽Ŀ�귽����(
			����:������Ҫ��Article��ʵ�����ֵ��������(Ŀ�귽��)�Ĳ�����,��Ŀ�귽��û���κ�ע��������,
			���Ǿ���Ҫ��@ModelAttributeע��ķ�������Ҫ��keyΪarticle��vo���뵽Map�С�
		)
		��.�������Ŀ�괦���������������ʹ����@ModelAttribute(value=""),����Ҫ�������
		��ע���valueֵ��һ����(
			���ǵ������ڴ�����(Ŀ�귽��)�������������@ModelAttribute(value="key")ע���˵Ļ�
			,��ô������ModelAttributeע���˵ķ����н���ͬ��key���뵽map�оͿ�����
		)
		
	 */

	@ModelAttribute
	public Article getArticle(@RequestParam(value="id",required=false) String id,Model model){
		Article a=new Article();
		if(id!=null){
			a.setId(id);
			return articleService.getArticle(a);
		}
		return a; 
		
	}
	
	/**
	 * �޸�����
	 * @param article
	 * @param model
	 * @return
	 */
	
	@RequestMapping("/form")
	public String form(Article article,Model model){
		listAll(model);
		return "sys/sysManager";
	}
	/**
	 * ��ʾ���ºͱ༭����ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping("/sysManager")
	public String sysManager(Article article,Model model){
		//��ʾ��һҳ�����ݺ����Եķ���
		listAll(model);
		return "sys/sysManager";
	}
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	@RequestMapping("del")
	public String delete(@RequestParam("id") String id,Model model){
		listAll(model);
		Article article=new Article();
		article.setId(id);
		articleService.delete(article);
		return "redirect:/a/article/sysManager";
	}
	/**
	 * ��̨����->���͹�����ʾ��һҳ������ 
	 * @param model
	 */
	private void listAll(Model model){
		/*����ʹ��,��ʱû��������ģ��
		 * 
		 * */
		List<Category> categorys=Lists.newArrayList();
		categorys.add(new Category("001","Java����", " "));
		categorys.add(new Category("002",".net����", " "));
		categorys.add(new Category("003","���ݿ⼼��", " "));
		categorys.add(new Category("004","��׿����", " "));
		categorys.add(new Category("005","IOS����", " "));
		categorys.add(new Category("006","WEBǰ�˼���", " "));
		model.addAttribute("categorys", categorys);
		List<Article> articles=articleService.findArticleByUser(null);
		model.addAttribute("articles", articles);
	}
}
