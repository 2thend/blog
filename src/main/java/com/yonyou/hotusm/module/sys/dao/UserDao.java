package com.yonyou.hotusm.module.sys.dao;

import java.util.List;

import com.yonyou.hotusm.common.persistence.CrudDao;
import com.yonyou.hotusm.common.persistence.annoation.MyBatisDao;
import com.yonyou.hotusm.module.sys.entity.User;


@MyBatisDao
public interface UserDao extends CrudDao<User>{
	public void batchInsert(List<User> list);
	public User getById(String id);
}
