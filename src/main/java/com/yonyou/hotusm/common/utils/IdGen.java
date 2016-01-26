package com.yonyou.hotusm.common.utils;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.UUID;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
@Service
@Lazy(false)
public class IdGen implements SessionIdGenerator{
	
	private static SecureRandom secureRandom;
	
	/**
	 * ��װJDK�Դ���UUID��ͨ��random����
	 */
	public static String uuid(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static long randomLong(){
		return Math.abs(secureRandom.nextLong());
	}

	public Serializable generateId(Session session) {
		return IdGen.uuid();
	}
	

}
