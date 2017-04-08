package com.changez.sm.base.bean;

import java.util.Set;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月6日 下午5:31:29
 */
public class Ordertail {

	private int id;
	private int orderId;
	private int itemId;
	private int itemNum;
	private Items items;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Ordertail [id=" + id + ", orderId=" + orderId + ", itemId="
				+ itemId + ", itemNum=" + itemNum + ", items=" + items + "]";
	}
	
	
}
