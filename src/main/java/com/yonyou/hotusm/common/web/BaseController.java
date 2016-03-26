package com.yonyou.hotusm.common.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *controller基础支持类 
 * @author Hotusm
 *
 */
public class BaseController {
	
	@Value("${web.front.view}")
	protected String frontUrl;//前端路径
	
	@Value("${web.sys.view}")
	protected String sysUrl;//后台管理路径
	
	/**
	 *1. 在@ExceptionHandler注解的方法中可以加入Exception,能够将异常传入
	 *2.方法的入参中不能传入Map,Model,如果希望将参数传入到页面中,我们可以直接使用
	 *ModelAndView
	 * @param e
	 * @return
	 */
	@ExceptionHandler({Exception.class})
	public String bindException(Exception e){
		System.out.println("出现异常:"+e.getMessage());
		return "error/500";
	}
	//初始化数据绑定 可以对某些字段进行修改
	@InitBinder
	public void bind(WebDataBinder dataBinder){
		//dataBinder.registerCustomEditor(requiredType, propertyEditor);
	}
}
