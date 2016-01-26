package com.yonyou.hotusm.common.security.session;

import java.util.Collection;

import org.apache.shiro.session.Session;

/**
 * sessionDAO
 * @author Hotusm
 * v2015-10-27
 *
 */
public interface SessionDAO extends org.apache.shiro.session.mgt.eis.SessionDAO{
	
	/**
	 * 获取全是的会话
	 * @param includeLeave 是否包括离线
	 * @return
	 */
	public Collection<Session> getActiveSessions(boolean includeLeave);
	/**
	 * 
	 * @param includeLeave 是否保存离线
	 * @param principal 传入的身份
	 * @param filterSession 需要过滤掉的Session 
	 * @return
	 */
	public Collection<Session> getActiveSessions(boolean includeLeave,Object principal,Session filterSession);
}
