package com.secondhandmarket.action.useradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.UserAdModule;

public class CheckCustomerRegistInfoAction extends ActionSupport{
	private UserAdModule userAdModule;
	
	public String execute(){
		this.userAdModule.checkCustomersRegist();
		return SUCCESS;
	}

	public UserAdModule getUserAdModule() {
		return userAdModule;
	}

	public void setUserAdModule(UserAdModule userAdModule) {
		this.userAdModule = userAdModule;
	}
	
}
