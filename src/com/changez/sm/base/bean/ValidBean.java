package com.changez.sm.base.bean;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.NotBlank;

import com.changez.sm.base.bean.group.user.UserGroup1;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月17日 下午3:23:09
 */
public class ValidBean {

	@NotBlank(message="用户名不能为空", groups= {UserGroup1.class})
	private String name;
	
	@Max(value=120, message="年龄最大为120")
	private Integer age;
	
	// 使用配置文件中的错误信息， properties中的key： message="{key}"。 {}：占位符
	@NotBlank(message="{validator.user.address}")
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "ValidBean [name=" + name + ", age=" + age + ", address="
				+ address + "]";
	}
	
	
}
