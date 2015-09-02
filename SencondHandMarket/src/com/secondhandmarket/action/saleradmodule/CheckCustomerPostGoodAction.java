package com.secondhandmarket.action.saleradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.SalerAdModule;

public class CheckCustomerPostGoodAction extends ActionSupport{
   private int isAdmin;
   private SalerAdModule salerModule;
   
   @Override
public String execute(){
	   this.salerModule.checkCustomerPostGood(isAdmin);
	   return SUCCESS;
   }

public int getIsAdmin() {
	return isAdmin;
}

public void setIsAdmin(int isAdmin) {
	this.isAdmin = isAdmin;
}

public SalerAdModule getSalerModule() {
	return salerModule;
}

public void setSalerModule(SalerAdModule salerModule) {
	this.salerModule = salerModule;
}
   
   
}
