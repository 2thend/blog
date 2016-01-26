package com.yonyou.hotusm.module.sys.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Service;

@Service
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter{
	
	
	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		boolean rememberMe=isRememberMe(request);
		if (password==null){
			password = "";
		}
		
		System.out.println("username:"+username+"password:"+password+"rememberMe"+rememberMe);
		return new UsernamePasswordToken(username, password);
	}
	
	
	
	/**
	 * ��¼�ɹ�֮����תURL
	 */
	public String getSuccessUrl() {
		return super.getSuccessUrl();
	}
	
	@Override
	protected void issueSuccessRedirect(ServletRequest request,
			ServletResponse response) throws Exception {
			 WebUtils.issueRedirect(request, response, getSuccessUrl(), null, true);
	}

	/**
	 * ��¼ʧ�ܵ����¼�
	 */
	@Override
	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest request, ServletResponse response) {
		System.out.println("��¼ʧ��");
        return true;
	}

}
