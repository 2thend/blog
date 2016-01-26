package com.yonyou.hotusm.common.persistence.annoation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Hotusm
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Component
@Target(ElementType.TYPE)
@Documented
public @interface MyBatisDao {
	/*��Ա���޲����ķ�������ʽ������
	 * 
	 * */
	String value() default"";
}
