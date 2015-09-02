package com.secondhandmarket.action.useradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.UserAdModule;

public class UnlockCustomerAction extends ActionSupport{
     private int cid, aid;
     private UserAdModule userAdModule;
     
     @Override
	public String execute(){
    	 this.userAdModule.unlockCustomer(cid, aid);
    	 return SUCCESS;
     }

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public UserAdModule getUserAdModule() {
		return userAdModule;
	}

	public void setUserAdModule(UserAdModule userAdModule) {
		this.userAdModule = userAdModule;
	}
}
