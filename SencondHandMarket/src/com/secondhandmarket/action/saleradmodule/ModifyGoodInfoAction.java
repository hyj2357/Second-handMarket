package com.secondhandmarket.action.saleradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.SalerAdModule;

public class ModifyGoodInfoAction extends ActionSupport{
      private int gid;
      private float price;
      private String intro,itemname,category,name,upload="false";  //itemname = gname  
      private SalerAdModule salerAdModule;
      
      @Override
	public String execute(){
    	  upload = this.salerAdModule.modifyGoodInfo(gid, price, intro, itemname, category, name)?"true":"false";
    	  return SUCCESS;
      }

	public int getGid() {
		return gid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SalerAdModule getSalerAdModule() {
		return salerAdModule;
	}

	public void setSalerAdModule(SalerAdModule salerAdModule) {
		this.salerAdModule = salerAdModule;
	}

	public void setGid(int gid) {
		this.gid = gid;
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

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}
}
