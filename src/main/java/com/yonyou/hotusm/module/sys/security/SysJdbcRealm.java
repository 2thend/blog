package com.yonyou.hotusm.module.sys.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

/**
 * ʹ��jdbcRealm  �������ļ������ö��realm ��realmΪ�����ʱ��  
 * ���õ���ModularRealmAuthenticator������֤  Ĭ������µĲ���(AuthenticationStrategy)ʹ�õ�
 * ��ֻҪһ��realm��֤ͨ����  ��ô����ͨ��
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
