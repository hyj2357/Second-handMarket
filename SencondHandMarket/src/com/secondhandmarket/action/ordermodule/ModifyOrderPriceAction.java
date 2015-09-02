package com.secondhandmarket.action.ordermodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.OrderModule;

public class ModifyOrderPriceAction extends ActionSupport{
	private int salerId,oid;
	private float price;
    private OrderModule orderModule;
    
    public String execute(){
    	this.orderModule.modifyOrderPrice(salerId, oid, price);
    	return SUCCESS;
    }

	public int getSalerId() {
		return salerId;
	}

	public void setSalerId(int salerId) {
		this.salerId = salerId;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public OrderModule getOrderModule() {
		return orderModule;
	}

	public void setOrderModule(OrderModule orderModule) {
		this.orderModule = orderModule;
	}  
}