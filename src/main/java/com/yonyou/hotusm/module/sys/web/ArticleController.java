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
	 * @ModelAttribute的使用方式:
	 * 1.被注解的方法,会在每一个目标方法执行前被springMVC先调用执行
	 * 2.执行流程:
	 * 1).执行@ModelAttribute注解修饰的方法(一般会获取到对象,并且将对象放入到模型中)
	 * 2).SpringMVC从模型中取出对象,并且将表单的请求参数赋值给该对象相对应的属性
	 * 3).SpringMVC再将上述的对象传入到目标方法的参数中
	 * 4).注意:
		①.这里的键必须是首字母小写的类名,如果键(key)错误的,那么不能够将属性值传入到目标方法中(
			例如:我们需要将Article的实体对象赋值到处理器(目标方法)的参数中,在目标方法没有任何注解的情况下,
			我们就需要在@ModelAttribute注解的方法中需要将key为article的vo放入到Map中。
		)
		②.但是如果目标处理器方法的入参上使用了@ModelAttribute(value=""),则需要和入参上
		的注解的value值是一样的(
			但是当我们在处理器(目标方法)的入参中设置了@ModelAttribute(value="key")注解了的话
			,那么我们在ModelAttribute注解了的方法中将相同的key放入到map中就可以了
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
	 * 修改文章
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
	 * 显示文章和编辑文章页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/sysManager")
	public String sysManager(Article article,Model model){
		//显示第一页的数据和所以的分类
		listAll(model);
		return "sys/sysManager";
	}
	/**
	 * 删除文章
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
	 * 后台管理->博客管理显示第一页的数据 
	 * @param model
	 */
	private void listAll(Model model){
		/*测试使用,暂时没有做分类模块
		 * 
		 * */
		List<Category> categorys=Lists.newArrayList();
		categorys.add(new Category("001","Java技术", " "));
		categorys.add(new Category("002",".net技术", " "));
		categorys.add(new Category("003","数据库技术", " "));
		categorys.add(new Category("004","安卓技术", " "));
		categorys.add(new Category("005","IOS技术", " "));
		categorys.add(new Category("006","WEB前端技术", " "));
		model.addAttribute("categorys", categorys);
		List<Article> articles=articleService.findArticleByUser(null);
		model.addAttribute("articles", articles);
	}
}
