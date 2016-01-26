package com.yonyou.hotusm.module.sys.entity;

import com.yonyou.hotusm.common.persistence.DataEntity;

/**
 * 用户实体
 * @author Hotusm
 *
 */
public class User extends DataEntity<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -771858710555715746L;
	/**
	 * 密码
	 */
	protected String password;
	/**
	 * 姓名
	 */
	protected String name;
	/**
	 * 登录名
	 * 
	 */
	protected String loginName;
	/**
	 * 地址
	 */
	protected String address;
	/**
	 * 电话
	 */
	protected String phone;
	/**
	 * 手机
	 */
	protected String mobilePhone;
	/**
	 * 年龄
	 */
	protected String age;
	/**
	 * 头像的地址
	 */
	protected String photo;
	/**
	 * 性别
	 */
	protected String gender;
	/**
	 * 生日
	 * 
	 */
	protected String birthday;
	/**
	 * 是否能允许登录1 代表允许登录 0代表不允许登录
	 */
	protected String loginFlag;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [password=" + password + ", name=" + name + ", loginName="
				+ loginName + ", address=" + address + ", phone=" + phone
				+ ", mobilePhone=" + mobilePhone + ", age=" + age + ", photo="
				+ photo + ", gender=" + gender + ", birthday=" + birthday
				+ ", loginFlag=" + loginFlag + "]";
	}
	
	
}
