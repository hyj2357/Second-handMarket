package com.secondhandmarket.action.goodmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.GoodModule;

public class SearchGoodAction extends ActionSupport{
      private float price;
      private String intro,category;
      private int isOnline;
      private GoodModule goodModule;
      
      @Override
	public String execute(){
    	  this.goodModule.searchGood(price, intro, isOnline, category);
    	  return SUCCESS;
      }
	public GoodModule getGoodModule() {
		return goodModule;
	}
	public void setGoodModule(GoodModule goodModule) {
		this.goodModule = goodModule;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}      
}
