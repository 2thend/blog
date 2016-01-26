package com.yonyou.hotusm.common.persistence;

import java.util.List;

/**
 * DAO ������֧����
 * @author Hotusm
 *
 * @param <T>
 */
public interface CrudDao<T> extends BaseDao{
	
	/**����id��ȡʵ��
	 * @param id
	 * @return
	 */
	public T get(String id);
	/**
	 * ������ʾ��ȡʵ�����
	 * @param entity
	 * @return
	 */
	public T get(T entity);
	/**
	 * ��ѯ���е�����
	 * @return
	 */
	public List<T> findList();
	/**
	 * 
	 */
	public List<T> findList(T entity);
	/**
	 * �������
	 * @param entity
	 */
	public void insert(T entity);
	/**
	 * ɾ������
	 * @param id
	 */
	public void delete(String id);
	/**
	 * ɾ������
	 * @param entitiy
	 */
	public void delete(T entitiy);
	/**
	 * ��������
	 * @param entity
	 */
	public void delete(List<T> entity);
	/**
	 * ���²���
	 * @param entity
	 */
	public void update(T entity);
	
}
