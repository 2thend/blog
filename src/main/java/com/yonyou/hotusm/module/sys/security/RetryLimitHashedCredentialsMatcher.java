package com.yonyou.hotusm.module.sys.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * 
 * @author Hotusm
 * 
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher{

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		System.out.println("==========");
		return super.doCredentialsMatch(token, info);
	}
	
	
}
