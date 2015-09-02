package com.secondhandmarket.action.saleradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.SalerAdModule;

public class OnlineGoodAction extends ActionSupport{
     private int posterId,gid;
     private SalerAdModule salerAdModule;
     
     public String execute(){
    	 this.salerAdModule.onlineGood(posterId, gid);
    	 return SUCCESS;
     }

	public int getPosterId() {
		return posterId;
	}

	public void setPosterId(int posterId) {
		this.posterId = posterId;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public SalerAdModule getSalerAdModule() {
		return salerAdModule;
	}

	public void setSalerAdModule(SalerAdModule salerAdModule) {
		this.salerAdModule = salerAdModule;
	}
}
