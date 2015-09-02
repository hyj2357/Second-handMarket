package com.secondhandmarket.action.customeradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.CustomerAdModule;

public class CommentGoodAction extends ActionSupport{
     private int cid,gid;
     private String content;
     private CustomerAdModule customerAdModule;
     
     @Override
	public String execute(){
    	this.customerAdModule.commentGood(cid, gid, content);
        return SUCCESS;	 
     }
     
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
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
