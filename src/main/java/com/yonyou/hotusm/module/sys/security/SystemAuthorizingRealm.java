package com.yonyou.hotusm.module.sys.security;

import java.io.Serializable;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.hotusm.common.utils.Encodes;
import com.yonyou.hotusm.module.sys.dao.UserDao;
import com.yonyou.hotusm.module.sys.entity.User;
import com.yonyou.hotusm.module.sys.service.UserService;
import com.yonyou.hotusm.module.sys.util.UserUtils;

@Service
public class SystemAuthorizingRealm extends AuthorizingRealm implements InitializingBean{
	
	@Autowired
	private UserDao userDao;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addStringPermission("sys:manager");
		info.addStringPermission("user");
		System.out.println("开始授权");
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken=(UsernamePasswordToken) token; 
		String username=upToken.getUsername();
		User user=new User();
		user.setLoginName(username);
		user=userDao.get(user);
		
		if(user!=null){

			byte[] salt = Encodes.decodeHex(user.getPassword().substring(0,16));
			return new SimpleAuthenticationInfo(username, 
				user.getPassword().substring(16), ByteSource.Util.bytes(salt), getName());
		}else{
			throw new UnauthenticatedException();
		}
		
	}

	public static class Principal implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private String id; // 编号
		private String loginName; // 登录名
		private String name; // 姓名
		

		public Principal(User user) {
			this.id = user.getId();
			this.loginName = user.getLoginName();
			this.name = user.getName();
		}

		public String getId() {
			return id;
		}

		public String getLoginName() {
			return loginName;
		}

		public String getName() {
			return name;
		}


		/**
		 * 获取SESSIONID
		 */
		public String getSessionid() {
			try{
				return (String) UserUtils.getSession().getId();
			}catch (Exception e) {
				return "";
			}
		}
		
		@Override
		public String toString() {
			return id;
		}

	}
	//在bean初始化完成以后  设置校验的规则
	@Override
	public void afterPropertiesSet() throws Exception {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(UserService.HASH_ALGORITHM);
		matcher.setHashIterations(UserService.HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
		
	}

}
