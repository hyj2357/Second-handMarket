package com.secondhandmarket.action.goodmodule;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.GoodModule;

public class SearchGoodByPosterAction extends ActionSupport{
     private String poster;
     private GoodModule goodModule;
     private List goodList;
     
     @Override
	public String execute(){
    	 this.goodList = this.goodModule.searchGoodByPoster(poster);
    	 return SUCCESS;
     }

	public List getGoodList() {
		return goodList;
	}

	public void setGoodList(List goodList) {
		this.goodList = goodList;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public GoodModule getGoodModule() {
		return goodModule;
	}

	public void setGoodModule(GoodModule goodModule) {
		this.goodModule = goodModule;
	}
}
