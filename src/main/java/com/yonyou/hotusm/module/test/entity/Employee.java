package com.yonyou.hotusm.module.test.entity;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 * 测试使用的vo
 * @author Hotusm
 *
 */
public class Employee {
	
/**
 * 1.测试JSR 303
 */
//	private String id;
//	
//	@NotEmpty	
//	private String name;
//	private Integer age;
//	
//	/**
//	 * 设置格式化的形式
//	 * 注意格式化的时候 在springmvc中的配置文件必须配置<mvc:annotation-driven/>
//	 * 注解
//	 * 
//	 */
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date birth;
//	//数字格式化
//	@NumberFormat(pattern="#,###,###.#")
//	private Float salary;
//	
//	
//	public Employee() {
//		super();
//	}
//	public Employee(String id, String name, Integer age, Date birth) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.age = age;
//		this.birth = birth;
//	}
//	
//	public Float getSalary() {
//		return salary;
//	}
//	public void setSalary(Float salary) {
//		this.salary = salary;
//	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Integer getAge() {
//		return age;
//	}
//	public void setAge(Integer age) {
//		this.age = age;
//	}
//	public Date getBirth() {
//		return birth;
//	}
//	public void setBirth(Date birth) {
//		this.birth = birth;
//	}
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", age=" + age
//				+ ", birth=" + birth + ", salary=" + salary + "]";
//	}
	
	/**
	 * 测试RESTful CRUD
	 */
	private Integer id;
	@NotEmpty
	private String lastName;

	@Email
	private String email;
	//1 male, 0 female
	private Integer gender;
	
	private Department department;
	
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
	
	@NumberFormat(pattern="#,###,###.#")
	private Float salary;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Employee(Integer id, String lastName, String email, Integer gender,
			Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}

	public Employee() {
	}
	
}
