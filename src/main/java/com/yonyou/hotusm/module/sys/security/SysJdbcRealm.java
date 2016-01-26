package com.yonyou.hotusm.module.sys.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

/**
 * 使用jdbcRealm  在配置文件中设置多个realm 当realm为多个的时候  
 * 采用的是ModularRealmAuthenticator进行验证  默认情况下的策略(AuthenticationStrategy)使用的
 * 是只要一个realm验证通过了  那么就是通过
 * @author Hotusm
 *
 */

public class SysJdbcRealm extends JdbcRealm{

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("jdbc realm");
		return super.doGetAuthenticationInfo(token);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		return super.doGetAuthorizationInfo(principals);
	}
	
}
