package com.yonyou.hotusm.module.sys.entity;

import com.yonyou.hotusm.common.persistence.DataEntity;

/**
 * �û�ʵ��
 * @author Hotusm
 *
 */
public class User extends DataEntity<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -771858710555715746L;
	/**
	 * ����
	 */
	protected String password;
	/**
	 * ����
	 */
	protected String name;
	/**
	 * ��¼��
	 * 
	 */
	protected String loginName;
	/**
	 * ��ַ
	 */
	protected String address;
	/**
	 * �绰
	 */
	protected String phone;
	/**
	 * �ֻ�
	 */
	protected String mobilePhone;
	/**
	 * ����
	 */
	protected String age;
	/**
	 * ͷ��ĵ�ַ
	 */
	protected String photo;
	/**
	 * �Ա�
	 */
	protected String gender;
	/**
	 * ����
	 * 
	 */
	protected String birthday;
	/**
	 * �Ƿ��������¼1 ���������¼ 0���������¼
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
