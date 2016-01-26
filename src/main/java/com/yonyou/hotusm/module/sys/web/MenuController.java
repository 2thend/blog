package com.yonyou.hotusm.module.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yonyou.hotusm.common.web.BaseController;
import com.yonyou.hotusm.module.cms.entity.Article;
import com.yonyou.hotusm.module.cms.service.ArticleService;
import com.yonyou.hotusm.module.sys.entity.User;
import com.yonyou.hotusm.module.sys.service.UserService;
import com.yonyou.hotusm.module.sys.util.UserUtils;

@RequestMapping("menu")
@Controller
public class MenuController extends BaseController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/top")
	public String top(Model model){
		try {
			User user=UserUtils.getUser();
			model.addAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "sys/top";
	}
	@RequestMapping("/left")
	public String left(){
		
		return "sys/left";
	}
	@RequestMapping("/index")
	public String index(){
		return "sys/index";
	}
	@RequestMapping("/workspace")
	public String workspace(){
		return "sys/workspace";
	}
	
	@RequestMapping("/managerModel")
	public String managerModel(){
		return "sys/managerModel";
	}
	@RequestMapping("/design")
	public String design(){
		
		return "sys/design";
	}
	@RequestMapping("/tools")
	public String tools(){
		
		return "sys/tools";
	}
	@RequestMapping("/file")
	public String file(){
		
		return "sys/file";
	}
	@RequestMapping("/sysManager")
	public String sysManager(Model model){
		List<Article> articles=articleService.findArticleByUser(null);
		model.addAttribute("articles", articles);
		return "sys/sysManager";
	}
	

}
