package com.secondhandmarket.action.ordermodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.OrderModule;

public class PayOrderAction extends ActionSupport{

	private OrderModule orderModule;
	
	public String execute(){
		this.orderModule.payOrder();
		return SUCCESS;
	}

	public OrderModule getOrderModule() {
		return orderModule;
	}

	public void setOrderModule(OrderModule orderModule) {
		this.orderModule = orderModule;
	}
	
	
}