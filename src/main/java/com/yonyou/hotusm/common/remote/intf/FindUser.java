package com.yonyou.hotusm.common.remote.intf;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.yonyou.hotusm.module.sys.entity.User;


@WebService
public interface FindUser {
	
	@WebMethod
	public User findUserByName(String loginName);

}
