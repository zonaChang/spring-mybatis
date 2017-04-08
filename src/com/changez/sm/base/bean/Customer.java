package com.changez.sm.base.bean;

import java.util.Date;

public class Customer {
	private Long id;
	private String name;
	private String password;
	private Date birthday;
	private Long age;
	
	public Customer(Long id, String name, Long age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", birthday=" + birthday + ", age=" + age + "]";
	}
	
	

	
	
}
