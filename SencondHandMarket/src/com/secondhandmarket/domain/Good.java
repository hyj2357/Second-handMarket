package com.secondhandmarket.domain;

import java.util.Set;

public class Good {
   private int    gid;
   private float  price;
   private String intro;
   private int    isOnline;
   private String category;
   private String gname;
   
   private Customer poster;
   
   private Set<BuyerRecord> buyerRecordsSet;
   private Set<Collection> collectionsSet;
   private Set<MOrder> mordersSet;

public Set<BuyerRecord> getBuyerRecordsSet() {
	return buyerRecordsSet;
}

public void setBuyerRecordsSet(Set<BuyerRecord> buyerRecordsSet) {
	this.buyerRecordsSet = buyerRecordsSet;
}

public Set<Collection> getCollectionsSet() {
	return collectionsSet;
}

public void setCollectionsSet(Set<Collection> collectionsSet) {
	this.collectionsSet = collectionsSet;
}

public int getGid() {
	return gid;
}

public void setGid(int gid) {
	this.gid = gid;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

public String getIntro() {
	return intro;
}

public void setIntro(String intro) {
	this.intro = intro;
}

public int getIsOnline() {
	return isOnline;
}

public void setIsOnline(int isOnline) {
	this.isOnline = isOnline;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public Customer getPoster() {
	return poster;
}

public void setPoster(Customer poster) {
	this.poster = poster;
}

public Set<MOrder> getMordersSet() {
	return mordersSet;
}

public void setMordersSet(Set<MOrder> mordersSet) {
	this.mordersSet = mordersSet;
}

public String getGname() {
	return gname;
}

public void setGname(String gname) {
	this.gname = gname;
}
   
}
