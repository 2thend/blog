package com.yonyou.hotusm.common.persistence;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.yonyou.hotusm.common.utils.IdGen;
import com.yonyou.hotusm.module.sys.entity.User;
import com.yonyou.hotusm.module.sys.util.UserUtils;

/**
 * 
 * 
 * @author Hotusm
 *	v2015-10
 *数据实体支持类
 * @param <T>
 */
public abstract class DataEntity<T> extends BaseEntity<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 191522316883975783L;
	/**
	 * 创建人
	 */
	protected User createBy;
	/**
	 * 创建时间
	 */
	protected String createDate;
	/**
	 * 最后修改人
	 * 
	 */
	protected User updateBy;
	/**
	 * 最好修改时间
	 * 
	 */
	protected String updateDate;
	/**
	 * 删除标记 1代表被删除  0代表没被删除
	 */
	protected boolean delFlag;
	/**
	 * 备注
	 * 
	 */
	protected String remarks;
	public User getCreateBy() {
		return createBy;
	}
	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public User getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}
	public boolean isDelFlag() {
		return delFlag;
	}
	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void preInsert(){
		if(StringUtils.isBlank(id)){
			id=IdGen.uuid();
		}
		User user=UserUtils.getUser();
		if(!StringUtils.isBlank(user.getId())){
			this.createBy=user;
			this.updateBy=user;
		}
		this.updateDate=new Date().toLocaleString();
		this.createDate=this.updateDate;
	}
	@Override
	public String toString() {
		return "DataEntity [id=" + id + "]";
	}
	
}
