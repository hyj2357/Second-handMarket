package com.secondhandmarket.action.customeradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.CustomerAdModule;

public class CheckGetGoodAction extends ActionSupport{
     private int cid;
     private CustomerAdModule customerAdModule;
     
	 public String execute(){
         this.customerAdModule.checkGetGood(cid);
		 return SUCCESS; 
     }
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

	public CustomerAdModule getCustomerAdModule() {
		return customerAdModule;
	}

	public void setCustomerAdModule(CustomerAdModule customerAdModule) {
		this.customerAdModule = customerAdModule;
	}
}
