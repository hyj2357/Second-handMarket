package com.secondhandmarket.action.customeradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.CustomerAdModule;

public class CreatOrderAction extends ActionSupport{
	private int customerId,gid;
	private CustomerAdModule customerAdModule;
	
	@Override
	public String execute(){
		this.customerAdModule.createOrder(customerId, gid);
		return SUCCESS;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public CustomerAdModule getCustomerAdModule() {
		return customerAdModule;
	}
	public void setCustomerAdModule(CustomerAdModule customerAdModule) {
		this.customerAdModule = customerAdModule;
	}
}
