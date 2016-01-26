package com.yonyou.hotusm.common.web;

import java.net.BindException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *controller����֧���� 
 * @author Hotusm
 *
 */
public class BaseController {
	
	@Value("${web.front.view}")
	protected String frontUrl;//ǰ��·��
	
	@Value("${web.sys.view}")
	protected String sysUrl;//��̨����·��
	
	@ExceptionHandler({BindException.class})
	public String bindException(){
		
		return "/error/400";
	}
}
