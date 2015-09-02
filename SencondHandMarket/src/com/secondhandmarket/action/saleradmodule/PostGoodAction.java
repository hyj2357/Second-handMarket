package com.secondhandmarket.action.saleradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.SalerAdModule;

public class PostGoodAction extends ActionSupport{
     private float price;
     private String intro,itemname,name;  //itemname = gname
     private int isOnline;
     private String category,upload="false";
     private SalerAdModule salerAdModule;
     
     public String execute(){
    	 this.upload = this.salerAdModule.postGood(price, intro, itemname, isOnline, category, name)?"true":"false";
    	 return SUCCESS;
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
	public int getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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