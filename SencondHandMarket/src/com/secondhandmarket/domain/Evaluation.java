package com.secondhandmarket.domain;

public class Evaluation {
   private int    eid;
   private String content;
   private String score;
   private Customer cs;
   private Good gd;
   
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getScore() {
	return score;
}
public void setScore(String score) {
	this.score = score;
}
public Customer getCs() {
	return cs;
}
public void setCs(Customer cs) {
	this.cs = cs;
}
public Good getGd() {
	return gd;
}
public void setGd(Good gd) {
	this.gd = gd;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
   
   
}
