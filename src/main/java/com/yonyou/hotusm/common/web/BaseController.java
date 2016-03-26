package com.yonyou.hotusm.common.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

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
	
	/**
	 *1. ��@ExceptionHandlerע��ķ����п��Լ���Exception,�ܹ����쳣����
	 *2.����������в��ܴ���Map,Model,���ϣ�����������뵽ҳ����,���ǿ���ֱ��ʹ��
	 *ModelAndView
	 * @param e
	 * @return
	 */
	@ExceptionHandler({Exception.class})
	public String bindException(Exception e){
		System.out.println("�����쳣:"+e.getMessage());
		return "error/500";
	}
	//��ʼ�����ݰ� ���Զ�ĳЩ�ֶν����޸�
	@InitBinder
	public void bind(WebDataBinder dataBinder){
		//dataBinder.registerCustomEditor(requiredType, propertyEditor);
	}
}
