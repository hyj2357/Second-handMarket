package com.secondhandmarket.domain;

import java.sql.Timestamp;

public class Message {
    private int mid;
    private String title;
    private String content;
    private Timestamp mstime;
    private int category;
    private int hasRead;
    
    private Customer sender;    
    private Customer receiver;
	
    public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Customer getSender() {
		return sender;
	}
	public void setSender(Customer sender) {
		this.sender = sender;
	}
	public Customer getReceiver() {
		return receiver;
	}
	public void setReceiver(Customer receiver) {
		this.receiver = receiver;
	}
	public Timestamp getMstime() {
		return mstime;
	}
	public void setMstime(Timestamp mstime) {
		this.mstime = mstime;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getHasRead() {
		return hasRead;
	}
	public void setHasRead(int hasRead) {
		this.hasRead = hasRead;
	}
}
