package com.secondhandmarket.service;

import java.util.Map;

import com.secondhandmarket.domain.MOrder;

public interface OrderModule {
	
     public boolean modifyOrderPrice(int salerId,int oid,float price);
     
     public boolean payOrder();
     
     public boolean cancelOrder(int buyerId,int oid);
     
     public Map<String,Object[]> checkGetOrder(int salerId);
     
     public MOrder checkOrderInfo(int oid);
     
     public Map<String,Object[]> checkSendOrder(int buyerId);
}
