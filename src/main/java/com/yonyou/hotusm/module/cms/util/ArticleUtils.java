package com.yonyou.hotusm.module.cms.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ���¹�����
 * @author Hotusm
 *
 */
public class ArticleUtils {
	
	/**
	 * ��ҳ����ת��
	 * @param target
	 * @return
	 */
	public static String transCodage(String target){
		
		String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //����script��������ʽ 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //����style��������ʽ 
        String regEx_html="<[^>]+>"; //����HTML��ǩ��������ʽ 
         
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(target); 
        target=m_script.replaceAll(""); //����script��ǩ 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(target); 
        target=m_style.replaceAll(""); //����style��ǩ 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(target); 
        target=m_html.replaceAll(""); //����html��ǩ 
        
    	if(target.length()<240){
    		
    	}else{
    		target=target.substring(0,240);
    	}
    	
		return target+"...";
//		String tmpString =target.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", "");//ȥ��������Ӣ�ķ���
//    	char[] carr = tmpString.toCharArray();
//    	for(int i = 0; i<tmpString.length();i++){
//    		if(carr[i] < 0xFF){
//    			carr[i] = ' ' ;//���˵��Ǻ�������
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
