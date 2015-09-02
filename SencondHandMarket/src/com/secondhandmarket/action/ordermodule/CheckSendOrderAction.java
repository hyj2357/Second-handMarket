package com.secondhandmarket.action.ordermodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.OrderModule;

public class CheckSendOrderAction extends ActionSupport{
   private int buyerId;
   private OrderModule orderModule;
   
   @Override
public String execute(){
	   this.orderModule.checkSendOrder(buyerId);
	   return SUCCESS;
   }

public int getBuyerId() {
	return buyerId;
}

public void setBuyerId(int buyerId) {
	this.buyerId = buyerId;
}

public OrderModule getOrderModule() {
	return orderModule;
}

public void setOrderModule(OrderModule orderModule) {
	this.orderModule = orderModule;
}
   
   
}
