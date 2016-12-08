package com.yonyou.hotusm.common.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.yonyou.hotusm.module.sys.entity.User;

/**
 * 1.自定义转化器  将字符串转化为用户vo
 * 2.必须实现接口Converter<S,T>,将S转化为T
 * 
 * @author Hotusm
 *
 */
@Service
public class UserConversionService implements Converter<String, User>{

	/**
	 * 传入字符串转化为user
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
