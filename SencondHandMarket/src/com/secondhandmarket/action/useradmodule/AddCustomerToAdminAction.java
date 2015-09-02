package com.secondhandmarket.action.useradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.UserAdModule;

public class AddCustomerToAdminAction extends ActionSupport{
	private int cid,said;
	private UserAdModule userAdModule;
	
	@Override
	public String execute(){
		this.userAdModule.addCustomerToAdmin(cid, said);
		return SUCCESS;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getSaid() {
		return said;
	}

	public void setSaid(int said) {
		this.said = said;
	}

	public UserAdModule getUserAdModule() {
		return userAdModule;
	}

	public void setUserAdModule(UserAdModule userAdModule) {
		this.userAdModule = userAdModule;
	}
}
