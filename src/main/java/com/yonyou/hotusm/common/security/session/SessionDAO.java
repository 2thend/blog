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
	 * ��ȡȫ�ǵĻỰ
	 * @param includeLeave �Ƿ��������
	 * @return
	 */
	public Collection<Session> getActiveSessions(boolean includeLeave);
	/**
	 * 
	 * @param includeLeave �Ƿ񱣴�����
	 * @param principal ��������
	 * @param filterSession ��Ҫ���˵���Session 
	 * @return
	 */
	public Collection<Session> getActiveSessions(boolean includeLeave,Object principal,Session filterSession);
}
