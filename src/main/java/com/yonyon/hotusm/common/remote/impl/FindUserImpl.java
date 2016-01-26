package com.yonyon.hotusm.common.remote.impl;

import javax.annotation.Resource;
import javax.jws.WebService;

import com.yonyou.hotusm.common.remote.intf.FindUser;
import com.yonyou.hotusm.module.sys.dao.UserDao;
import com.yonyou.hotusm.module.sys.entity.User;

@WebService
public class FindUserImpl implements FindUser{
	
	@Resource
	private UserDao dao;
	
	public User findUserByName(String loginName) {
		String msg="";
		System.out.println("loginName"+loginName);
		if(loginName==null){
			return new User();
		}
		User user=new User();
		user.setLoginName(loginName);
		user=dao.get(user);
		return user;
	}

}
