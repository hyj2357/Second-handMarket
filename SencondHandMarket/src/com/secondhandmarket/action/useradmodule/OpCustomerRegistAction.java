package com.secondhandmarket.action.useradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.UserAdModule;

public class OpCustomerRegistAction extends ActionSupport{
      private int cid, aid, op;
      private UserAdModule userAdModule;
      
      @Override
	public String execute(){
    	  this.userAdModule.opCustomerRegist(cid, aid, op);
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

	public int getOp() {
		return op;
	}

	public void setOp(int op) {
		this.op = op;
	}

	public UserAdModule getUserAdModule() {
		return userAdModule;
	}

	public void setUserAdModule(UserAdModule userAdModule) {
		this.userAdModule = userAdModule;
	}
}
