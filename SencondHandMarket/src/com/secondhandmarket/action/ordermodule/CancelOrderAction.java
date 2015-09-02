package com.secondhandmarket.action.ordermodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.OrderModule;

public class CancelOrderAction extends ActionSupport{
    private int buyerId,oid;
	private OrderModule orderModule;
    
	public String execute(){
		this.orderModule.cancelOrder(buyerId, oid);
		return SUCCESS;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public OrderModule getOrderModule() {
		return orderModule;
	}

	public void setOrderModule(OrderModule orderModule) {
		this.orderModule = orderModule;
	}
	
}
