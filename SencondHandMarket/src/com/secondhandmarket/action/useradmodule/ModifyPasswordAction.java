package com.secondhandmarket.action.useradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.UserAdModule;

public class ModifyPasswordAction extends ActionSupport{
     private int cid;
     private String password, newPassword;
     private UserAdModule userAdModule;
     
     @Override
	public String execute(){
    	 this.userAdModule.modifyPassword(cid, password, newPassword);
    	 return SUCCESS;
     }

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public UserAdModule getUserAdModule() {
		return userAdModule;
	}

	public void setUserAdModule(UserAdModule userAdModule) {
		this.userAdModule = userAdModule;
	}
}
