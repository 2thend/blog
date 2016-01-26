package com.yonyou.hotusm.module.cms.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文章工具类
 * @author Hotusm
 *
 */
public class ArticleUtils {
	
	/**
	 * 首页文章转码
	 * @param target
	 * @return
	 */
	public static String transCodage(String target){
		
		String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(target); 
        target=m_script.replaceAll(""); //过滤script标签 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(target); 
        target=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(target); 
        target=m_html.replaceAll(""); //过滤html标签 
        
    	if(target.length()<240){
    		
    	}else{
    		target=target.substring(0,240);
    	}
    	
		return target+"...";
//		String tmpString =target.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", "");//去掉所有中英文符号
//    	char[] carr = tmpString.toCharArray();
//    	for(int i = 0; i<tmpString.length();i++){
//    		if(carr[i] < 0xFF){
//    			carr[i] = ' ' ;//过滤掉非汉字内容
//    		}
//    	}
//    	tmpString=String.copyValueOf(carr).trim();
//    	if(tmpString.length()<340){
//    		
//    	}else{
//    		tmpString=tmpString.substring(0,340);
//    	}
    	//return tmpString+"...";
	}
}
