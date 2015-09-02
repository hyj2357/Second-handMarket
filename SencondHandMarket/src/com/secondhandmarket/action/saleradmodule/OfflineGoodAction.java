package com.secondhandmarket.action.saleradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.SalerAdModule;

public class OfflineGoodAction extends ActionSupport{
     private int gid;
     private String upload="false";
     private SalerAdModule salerAdModule;
     
     public String execute(){
    	 upload = this.salerAdModule.offlineGood(gid)?"false":"true";
    	 return SUCCESS;
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

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}
     
     
}
