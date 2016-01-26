package com.yonyou.hotusm.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yonyou.hotusm.common.config.Global;

/**
 * 
 * @author Hotusm
 *v2015-10-28
 */
public class Servlets {
	
	/**
	 * һ���ʱ��
	 */
	public static final long ONE_YEAR_SECONDS=60*60*60*30*12;
	
	// ��̬�ļ���׺
	private final static String[] staticFiles = org.apache.commons.lang.StringUtils.split(Global.getConfig("web.staticFile"), ",");
	
	// ��̬ӳ��URL��׺
	private final static String urlSuffix = Global.getUrlSuffix();
	
	/**
	 * 
	 * ȡ�������request
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		try {
			return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		} catch (Exception e) {
			return null;
		}
		
	}

	/**
     * �жϷ���URI�Ƿ��Ǿ�̬�ļ�����
	 * @throws Exception 
     */
    public static boolean isStaticFile(String uri){
		if (staticFiles == null){
			try {
				throw new Exception("��⵽��app.properties����û�����á�web.staticFile�����ԡ�����ʾ����\n#��̬�ļ���׺\n"
					+"web.staticFile=.css,.js,.png,.jpg,.gif,.jpeg,.bmp,.ico,.swf,.psd,.htc,.crx,.xpi,.exe,.ipa,.apk");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (org.apache.commons.lang.StringUtils.endsWithAny(uri, staticFiles) && !org.apache.commons.lang.StringUtils.endsWith(uri, urlSuffix)
				&& !org.apache.commons.lang.StringUtils.endsWith(uri, ".jsp") && !org.apache.commons.lang.StringUtils.endsWith(uri, ".java")){
			return true;
		}
		return false;
    }
    public static void setNoCacheHeader(HttpServletResponse response){
    	//HTTP 1.1
    	response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache,no-store,max-age=0");
    	//HTTP 1.0
    	response.setHeader(HttpHeaders.PRAGMA, "no-cache");
    	
    	response.setDateHeader(HttpHeaders.EXPIRES, 0);
    }
   // public static 
	
	
}
