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
	 * 使用@ControllerAdvice,如果出现错误那么就会直接跳到这个方法中来
	 * @return
	 */
	//@ExceptionHandler({Exception.class})
	public String exception(){
		return "error/500";
	}
}
