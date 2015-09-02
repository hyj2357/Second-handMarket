package com.secondhandmarket.domain;

import java.io.Serializable;

public class Collection implements Serializable{
    
	private int clid,gid;
    private String gname;
	private Customer cs;
    private Good gd;
    
    
	public int getClid() {
		return clid;
	}
	public void setClid(int clid) {
		this.clid = clid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
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
    
    
}
