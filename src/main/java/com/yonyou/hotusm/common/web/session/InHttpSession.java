package com.yonyou.hotusm.common.web.session;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.yonyou.hotusm.module.nosql.redis.JedisTemplate;

public class InHttpSession implements HttpSession{
	
	@Autowired
	private JedisTemplate jedisTemplate;

	public long getCreationTime() {
		return 0;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getLastAccessedTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setMaxInactiveInterval(int interval) {
		// TODO Auto-generated method stub
		
	}

	public int getMaxInactiveInterval() {
		// TODO Auto-generated method stub
		return 0;
	}

	public HttpSessionContext getSessionContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getValueNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAttribute(String name, Object value) {
		// TODO Auto-generated method stub
		
	}

	public void putValue(String name, Object value) {
		// TODO Auto-generated method stub
		
	}

	public void removeAttribute(String name) {
		// TODO Auto-generated method stub
		
	}

	public void removeValue(String name) {
		// TODO Auto-generated method stub
		
	}

	public void invalidate() {
		
	}

	public boolean isNew() {
		return false;
	}

}
