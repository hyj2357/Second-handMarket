package com.secondhandmarket.domain;

public class MOrder {
    private int oid;
    private int hasPay;
    private float price;
    private String gname;
    private Good gd;    
    
    //1-N关联
    private Customer buyer;
    private Customer saler;
    
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getHasPay() {
		return hasPay;
	}
	public void setHasPay(int hasPay) {
		this.hasPay = hasPay;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Good getGd() {
		return gd;
	}
	public void setGd(Good gd) {
		this.gd = gd;
	}
	public Customer getBuyer() {
		return buyer;
	}
	public void setBuyer(Customer buyer) {
		this.buyer = buyer;
	}
	public Customer getSaler() {
		return saler;
	}
	public void setSaler(Customer saler) {
		this.saler = saler;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
    
    
}
