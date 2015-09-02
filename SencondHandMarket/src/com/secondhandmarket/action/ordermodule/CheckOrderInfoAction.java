package com.secondhandmarket.action.ordermodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.OrderModule;

public class CheckOrderInfoAction extends ActionSupport{
    private int oid;
    private OrderModule orderModule;
    
    @Override
	public String execute(){
    	this.orderModule.checkOrderInfo(oid);
        return SUCCESS;	
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
