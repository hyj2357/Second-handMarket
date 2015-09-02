package com.secondhandmarket.domain;

import java.util.Set;

public class Customer implements java.io.Serializable{
    private int cid;
    private String name;
    private String password;
    private String province;
    private String city;
    private String area;
    private String school;
    private String qqnumber;
    private String phonenumber;
    private int authority,confirm;
    
    //1-N关联集合
    private Set<Evaluation> evaluations;
    private Set<Good> goods;
    private Set<Message> messages_receive,messages_send;
    private Set<BuyerRecord> buyerRecords_buy,buyerRecords_sale;
    private Set<Collection> collections;
    
    public Customer(int cid){
      this.cid = cid;
    }
    
    public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}
	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	public Set<Good> getGoods() {
		return goods;
	}
	public void setGoods(Set<Good> goods) {
		this.goods = goods;
	}
	public Set<Message> getMessages_receive() {
		return messages_receive;
	}
	public void setMessages_receive(Set<Message> messages_receive) {
		this.messages_receive = messages_receive;
	}
	public Set<Message> getMessages_send() {
		return messages_send;
	}
	public void setMessages_send(Set<Message> messages_send) {
		this.messages_send = messages_send;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) { 
		this.authority = authority;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Set<Collection> getCollections() {
		return collections;
	}
	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}
	public Set<BuyerRecord> getBuyerRecords_sale() {
		return buyerRecords_sale;
	}
	public void setBuyerRecords_sale(Set<BuyerRecord> buyerRecords_sale) {
		this.buyerRecords_sale = buyerRecords_sale;
	}
	public Set<BuyerRecord> getBuyerRecords_buy() {
		return buyerRecords_buy;
	}
	public void setBuyerRecords_buy(Set<BuyerRecord> buyerRecords_buy) {
		this.buyerRecords_buy = buyerRecords_buy;
	}

	public String getQqnumber() {
		return qqnumber;
	}

	public void setQqnumber(String qqnumber) {
		this.qqnumber = qqnumber;
	}

	public int getConfirm() {
		return confirm;
	}

	public void setConfirm(int confirm) {
		this.confirm = confirm;
	}
    
    
}
