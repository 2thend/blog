package com.yonyou.hotusm.module.sys.service;

import com.yonyou.hotusm.common.security.Digests;
import com.yonyou.hotusm.common.utils.Encodes;
import com.yonyou.hotusm.module.sys.dao.UserDao;
import com.yonyou.hotusm.module.sys.entity.User;
import com.yonyou.hotusm.module.sys.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
	@Autowired
	private UserDao userDao;

	@Transactional(readOnly=true)
	public void save(User user){
		try {
			if(user==null){
				return;
			}
			user.preInsert();
			userDao.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public User getUser(User user){
		if(user==null||user.getLoginName()==null){
			return null;
		}
		return userDao.get(user);
	}
	public void update(User user){
		User temp=UserUtils.getUser();
		if(user==null){
			return;
		}
		String password=user.getPassword();
		if(password.equals("")){
			password=temp.getPassword();
		}
		user.setId(temp.getId());
		userDao.update(user);
	}

	//为明文密码加密
	public String encryptionPassword(String plainPassword){
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
	}
	
}
