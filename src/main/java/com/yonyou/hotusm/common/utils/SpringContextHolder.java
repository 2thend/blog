package com.yonyou.hotusm.common.utils;

import org.apache.commons.lang.Validate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
/**
 * applicationContext静态化
 * 使用了ApplicationContextAware接口的类，如果受spring容器管理的
 * 话，那么就会自动的调用ApplicationContextAware中的setApplicationContext方法
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
	//获取Bean
	public static <T> T getBean(Class<T> requiredType){
		return (T) getApplicationContext().getBean(requiredType);
	}
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name){
		return (T) getApplicationContext().getBean(name);
	}
	
	public static void assertContextInjected(){
		Validate.isTrue(applicationContext==null, "application未注入 ，请在springContext.xml中注入SpringHolder!");
	}
	
}
