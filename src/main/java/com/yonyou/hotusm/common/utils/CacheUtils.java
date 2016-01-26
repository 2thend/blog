package com.yonyou.hotusm.common.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;


/**
 * ���湤����
 * @author Hotusm
 *
 */
public class CacheUtils {
	
	private static CacheManager cacheManager=SpringContextHolder.getBean("cacheManager");
	
	private static final String SYS_CACHE="sysCache";
	
	//��ȡ���� û�еĻ�������һ�� ���ҷ���
	public static Cache getCache(String cacheName){
		Cache cache=cacheManager.getCache(cacheName);
		if(cache!=null){
			return cache;
		}
		cacheManager.addCache(cacheName);
		cache=cacheManager.getCache(cacheName);
		cache.getCacheConfiguration().setEternal(true);
		return cache;
	}
	//�������ֵ���뵽
	public static void put(String cacheName,String key,String value){
		Element element=new Element(key,value);
		getCache(cacheName).put(element);
	}
	
	public static void put(String key,String value){
		
		Element element=new Element(key,value);
		getCache(SYS_CACHE).put(element);
	}
	//���� �������ͼ���ȡ����
	public static Object get(String cacheName,String key){
		Element element=getCache(cacheName).get(key);
		
		return element==null?null:element.getObjectValue();
	}
	//���ݼ���ȡ�����е�ֵ
	public static Object get(String key){
		return get(SYS_CACHE,key);
	}
	//ɾ������
	public static void remove(String key){
		remove(SYS_CACHE, key);
	}
	
	public static void remove(String cacheName,String key){
		if(get(key)==null){
			return;
		}
		getCache(cacheName).remove(key);
	}
	
}
