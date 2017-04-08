package com.changez.sm.base.bean;

import java.util.Date;
import java.util.Set;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月6日 下午5:28:29
 */
public class Orders {

	private String id;
	private String userId;
	private String orderNum;
	private Date createTime;
	private String note;
	private User user;
	private Set<Ordertail> ordertails;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Set<Ordertail> getOrdertails() {
		return ordertails;
	}
	public void setOrdertails(Set<Ordertail> ordertails) {
		this.ordertails = ordertails;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", orderNum="
				+ orderNum + ", createTime=" + createTime + ", note=" + note
				+ ", user=" + user + ", ordertails=" + ordertails + "]";
	}
	
	
}
