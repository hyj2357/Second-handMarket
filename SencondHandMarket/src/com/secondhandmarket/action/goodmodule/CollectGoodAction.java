package com.secondhandmarket.action.goodmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.GoodModule;

public class CollectGoodAction extends ActionSupport{
    private String name,upload="false";
    private int gid;
    private GoodModule goodModule;
	
	@Override
	public String execute(){
		upload = this.goodModule.collectGood(name, gid)?"true":"false";
		return SUCCESS;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public GoodModule getGoodModule() {
		return goodModule;
	}

	public void setGoodModule(GoodModule goodModule) {
		this.goodModule = goodModule;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}
}
