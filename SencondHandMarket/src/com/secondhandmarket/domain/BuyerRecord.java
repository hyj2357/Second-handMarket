package com.secondhandmarket.domain;

public class BuyerRecord {
	private int bid;
    private int hasPay;
    private String gname;
    private float price;
    private Good gd;
    private Customer cs_buy,cs_sale;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
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
	public Customer getCs_buy() {
		return cs_buy;
	}
	public void setCs_buy(Customer cs_buy) {
		this.cs_buy = cs_buy;
	}
	public Customer getCs_sale() {
		return cs_sale;
	}
	public void setCs_sale(Customer cs_sale) {
		this.cs_sale = cs_sale;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
    
    
}
