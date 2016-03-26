package com.yonyou.hotusm.common.utils;

import org.apache.commons.lang.Validate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
/**
 * applicationContext��̬��
 * ʹ����ApplicationContextAware�ӿڵ��࣬�����spring���������
 * ������ô�ͻ��Զ��ĵ���ApplicationContextAware�е�setApplicationContext����
 * @author Hotusm
 *
 */
@Service
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware,DisposableBean{
	
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		
		SpringContextHolder.applicationContext=applicationContext;
	}
	public void destroy() throws Exception {
		SpringContextHolder.clearHolder();
	}
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public static void clearHolder(){
		applicationContext=null;
	}
	//��ȡBean
	public static <T> T getBean(Class<T> requiredType){
		return (T) getApplicationContext().getBean(requiredType);
	}
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name){
		return (T) getApplicationContext().getBean(name);
	}
	
	public static void assertContextInjected(){
		Validate.isTrue(applicationContext==null, "applicationδע�� ������springContext.xml��ע��SpringHolder!");
	}
	
}
