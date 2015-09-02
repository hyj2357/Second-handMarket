package com.secondhandmarket.action.goodmodule;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.GoodModule;

public class CheckGoodsByClassAction extends ActionSupport{
	private String category;
	private GoodModule goodModule;
	private List goodList;
	
	public String execute(){
		this.goodList = this.goodModule.checkGoodsByClass(category);
	    return SUCCESS;
	}

	public List getGoodList() {
		return goodList;
	}

	public void setGoodList(List goodList) {
		this.goodList = goodList;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public GoodModule getGoodModule() {
		return goodModule;
	}

	public void setGoodModule(GoodModule goodModule) {
		this.goodModule = goodModule;
	}
}
