package com.yonyou.hotusm.common.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * @author Hotusm
 *
 */
//@ControllerAdvice
public class ExceptionController {
	
	/**
	 * ʹ��@ControllerAdvice,������ִ�����ô�ͻ�ֱ�����������������
	 * @return
	 */
	//@ExceptionHandler({Exception.class})
	public String exception(){
		return "error/500";
	}
}
