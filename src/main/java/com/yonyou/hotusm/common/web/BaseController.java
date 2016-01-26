package com.yonyou.hotusm.common.web;

import java.net.BindException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
	
	@ExceptionHandler({BindException.class})
	public String bindException(){
		
		return "/error/400";
	}
}
