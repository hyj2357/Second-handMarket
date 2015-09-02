package com.secondhandmarket.action.goodmodule;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.GoodModule;
import com.secondhandmarket.service.UserAdModule;

public class CheckCollectGoodsAction extends ActionSupport{
	private String name;
	private GoodModule goodModule;
	private List goodList;
	
	public String execute(){
		goodList = this.goodModule.checkCollectGoods(name);
		return SUCCESS;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public GoodModule getGoodModule() {
		return goodModule;
	}

	public void setGoodModule(GoodModule goodModule) {
		this.goodModule = goodModule;
	}
}
