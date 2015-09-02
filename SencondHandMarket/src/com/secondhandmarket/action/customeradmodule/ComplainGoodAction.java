package com.secondhandmarket.action.customeradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.CustomerAdModule;

public class ComplainGoodAction extends ActionSupport{
	private String name, poster, complain,upload="false";
	private CustomerAdModule customerAdModule;
	
	@Override
	public String execute(){
		upload = this.customerAdModule.complainGood(name,poster, complain)?"true":"false";
		return SUCCESS;
	}

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getComplain() {
		return complain;
	}

	public void setComplain(String complain) {
		this.complain = complain;
	}

	public CustomerAdModule getCustomerAdModule() {
		return customerAdModule;
	}

	public void setCustomerAdModule(CustomerAdModule customerAdModule) {
		this.customerAdModule = customerAdModule;
	}
}
