package com.yonyou.hotusm.module.sys.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.yonyou.hotusm.common.utils.SpringContextHolder;
import com.yonyou.hotusm.module.sys.dao.UserDao;
import com.yonyou.hotusm.module.sys.entity.User;
import com.yonyou.hotusm.module.sys.security.SystemAuthorizingRealm.Principal;

/**
 * 用户工具类
 * @author Hotusm
 *
 */
public class UserUtils {
	
	private static UserDao userDao=SpringContextHolder.getBean(UserDao.class);
	
	public static User getUser(){
		Principal principal=getPrincipal();
		if(principal!=null){
			User user=get(principal.getId());
			if(user!=null){
				return user;
			}
			return new User();
		}
		return new User();
	}
	
	public static User get(String userId){
		User user=userDao.getById(userId);
		return user;
	}
	public static Principal getPrincipal(){
		
		try {
			Subject subject=SecurityUtils.getSubject();
			String username= (String) subject.getPrincipal();
			if(username==null){
				return null;
			}
			User user=new User();
			user.setLoginName(username);
			user=userDao.get(username);
			Principal principal=new Principal(user);
			if(principal!=null){
				return principal;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Session getSession(){
		
		try {
			Subject subject=SecurityUtils.getSubject();
			Session session=subject.getSession(false);
			if(session==null){
				session=subject.getSession();
			}
			if(session!=null){
				return session;
			}
		} catch (Exception e) {
			
		}
		return null;
	}
}
