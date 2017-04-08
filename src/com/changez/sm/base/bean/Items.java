package com.changez.sm.base.bean;
/**
 * @desc: 
 * @auth: zona
 * 2017年2月6日 下午5:29:54
 */
public class Items {
	private String id;
	private String name;
	private double price;
	private String detail;
	private String pic;
	private String createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", price=" + price
				+ ", detail=" + detail + ", pic=" + pic + ", createTime="
				+ createTime + "]";
	}
	
	
}
