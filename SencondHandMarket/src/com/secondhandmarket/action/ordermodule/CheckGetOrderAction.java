package com.secondhandmarket.action.ordermodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.OrderModule;

public class CheckGetOrderAction extends ActionSupport{
	private int salerId;
	private OrderModule orderModule;
	
	@Override
	public String execute(){
		this.orderModule.checkGetOrder(salerId);
		return SUCCESS;
	}

	public int getSalerId() {
		return salerId;
	}

	public void setSalerId(int salerId) {
		this.salerId = salerId;
	}

	public OrderModule getMessageModule() {
		return orderModule;
	}

	public void setMessageModule(OrderModule orderModule) {
		this.orderModule = orderModule;
	}
}
