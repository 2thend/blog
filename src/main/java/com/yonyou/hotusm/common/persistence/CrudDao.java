package com.yonyou.hotusm.common.persistence;

import java.util.List;

/**
 * DAO 基本的支持类
 * @author Hotusm
 *
 * @param <T>
 */
public interface CrudDao<T> extends BaseDao{
	
	/**根据id获取实体
	 * @param id
	 * @return
	 */
	public T get(String id);
	/**
	 * 根据提示获取实体对象
	 * @param entity
	 * @return
	 */
	public T get(T entity);
	/**
	 * 查询所有的数据
	 * @return
	 */
	public List<T> findList();
	/**
	 * 
	 */
	public List<T> findList(T entity);
	/**
	 * 插入操作
	 * @param entity
	 */
	public void insert(T entity);
	/**
	 * 删除操作
	 * @param id
	 */
	public void delete(String id);
	/**
	 * 删除操作
	 * @param entitiy
	 */
	public void delete(T entitiy);
	/**
	 * 批量操作
	 * @param entity
	 */
	public void delete(List<T> entity);
	/**
	 * 更新操作
	 * @param entity
	 */
	public void update(T entity);
	
}
