package com.yonyou.hotusm.common.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.yonyou.hotusm.module.sys.entity.User;

/**
 * 1.�Զ���ת����  ���ַ���ת��Ϊ�û�vo
 * 2.����ʵ�ֽӿ�Converter<S,T>,��Sת��ΪT
 * 
 * @author Hotusm
 *
 */
@Service
public class UserConversionService implements Converter<String, User>{

	/**
	 * �����ַ���ת��Ϊuser
	 */
	public User convert(String source) {
		if(null!=source){
			/*  name-age */
			String[] vals = source.split("-");
			if(null!=vals&&vals.length==2){
				String name=vals[0];
				String age=vals[1];
				User user=new User();
				user.setName(name);
				user.setAge(age);
				return user;
			}
		}
		return null;
	}

}
