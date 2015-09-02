package com.secondhandmarket.action.customeradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.CustomerAdModule;

public class CommentSalerAction extends ActionSupport{
	private int customerId,salerId;
	private String evaluation;
	private CustomerAdModule customerAdModule;
	
	public String execute(){
		this.customerAdModule.commentSaler(customerId, salerId, evaluation);
	    return SUCCESS;	
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getSalerId() {
		return salerId;
	}
	public void setSalerId(int salerId) {
		this.salerId = salerId;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
	public CustomerAdModule getCustomerAdModule() {
		return customerAdModule;
	}
	public void setCustomerAdModule(CustomerAdModule customerAdModule) {
		this.customerAdModule = customerAdModule;
	}
	
	
}
