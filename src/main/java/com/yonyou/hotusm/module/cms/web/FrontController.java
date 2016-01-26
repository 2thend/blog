package com.yonyou.hotusm.module.cms.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonyou.hotusm.common.mapper.JsonMapper;
import com.yonyou.hotusm.common.web.BaseController;
import com.yonyou.hotusm.module.cms.entity.Article;
import com.yonyou.hotusm.module.cms.entity.ArticleData;
import com.yonyou.hotusm.module.cms.service.ArticleService;
import com.yonyou.hotusm.module.nosql.redis.JedisTemplate;
import com.yonyou.hotusm.module.sys.dao.UserDao;
import com.yonyou.hotusm.module.sys.entity.User;
import com.yonyou.hotusm.module.sys.entity.Weather;
import com.yonyou.hotusm.module.sys.security.FormAuthenticationFilter;
import com.yonyou.hotusm.module.sys.service.UserService;
import com.yonyou.hotusm.module.sys.service.Webservice;

@RequestMapping(value="/f")
@Controller
public class FrontController extends BaseController{
	@Autowired
	FormAuthenticationFilter formAuthenticationFilter;
	@Autowired
	UserService userService;
	@Autowired
	ArticleService articleService;
	@Autowired
	private JedisTemplate jedisTemplate;
	@Autowired
	private UserDao userDao;
	@Autowired
	private Webservice webservice;
	
	

	@RequestMapping(value="")
	public String front(Model model,HttpServletRequest request){
		userDao.get("1");
		//����login��url
//		String url=formAuthenticationFilter.getSuccessUrl();
//		System.out.println(url);
		//jedisTemplate.set("a", "abc");
		//jedisTemplate.lset("a", 1, "ccc");
//		jedisTemplate.lpush("b", "aaa");
//		jedisTemplate.lpush("b", "bbb");
//		jedisTemplate.lpush("b", "ccc");
		//jedisTemplate.get("b");
//		List<String> lists=jedisTemplate.lrange("b", 0, -1);
//		for(String str:lists){
//			System.out.println(str);
//		}
////		jedisTemplate.hset("c", "name", "luqibao");
//		jedisTemplate.hset("c", "age", "20");
//		jedisTemplate.hget("c", "name");
		List<Article> articles=articleService.getNewArticle(0, 0);
//		for(Article a:articles){
//			System.out.println("title:"+a.getTitle()+"content:"+a.getArticleData().getContent());
//		}
		model.addAttribute("articles", articles);
		//Long test=jedisTemplate.llen("b");
		//System.out.println(test);
		
		Weather w=new Weather();
		//��ȡ�û����ڳ��е���Ϣ
		String city=(String) request.getSession().getAttribute("city");
		
		if(null==city||"".equals(city)){
			//��ȡ�ͻ���ip��ַ
			String address=request.getRemoteAddr();
			//ֱ��ͨ���ӿڲ����������
			//city=webservice.getCity(address);
			//ʹ�ñ�������
			city=webservice.getCity(null);
			//�����ݴ���session��
			request.getSession().setAttribute("city", city);
		}
		
		//��ȡ������������е�������Ϣ
		String weather=jedisTemplate.get(city+"weather");
		w=(Weather) JsonMapper.fromJsonString(weather,Weather.class);
		
		if(w==null){
			
			try {
				w =webservice.getWeather(city);
			} catch (Exception e) {
				e.printStackTrace();
			}
			jedisTemplate.setex(city+"weather",1*60*60, JsonMapper.toJsonString(w));
		}
		//��ȡ�ػ�����û������û��ĳ���
		
		model.addAttribute("weather", w);
		return "front/index";
	}
	
	@RequestMapping(value="/articleView")
	public String articleView(@RequestParam(required=false) String articleId,Model model){
		//User user=UserUtils.getUser();
		Article article=new Article();
		article.setId(articleId);
		article=articleService.getArticle(article);
		ArticleData ad=new ArticleData();
		ad=article.getArticleData();
		model.addAttribute("article", article);
		model.addAttribute("articleData", ad);
		User user=article.getCreateBy();
		user=userDao.getById(user.getId());
		model.addAttribute("user", user);
		return "front/articleView";
	}
	
	@ResponseBody
	@RequestMapping("testJson")
	public  List<User> testJson(){
		List<User> users=com.google.common.collect.Lists.newArrayList();
		User u=new User();
		u.setName("123");
		users.add(u);
		return users;
	}

}
