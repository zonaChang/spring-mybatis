package com.changez.sm.base.bean;

import java.util.Date;
import java.util.Set;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月6日 下午5:25:49
 */
public class User {
	private String id;
	private String username;
	private Date birthday;
	private String sex;
	private String address;
	private Set<Orders> orders;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday="
				+ birthday + ", sex=" + sex + ", address=" + address
				+ ", orders=" + orders + "]";
	}
	
}
