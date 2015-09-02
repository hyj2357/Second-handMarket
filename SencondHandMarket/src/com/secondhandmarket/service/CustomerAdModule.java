package com.secondhandmarket.service;

import java.util.Map;

import com.secondhandmarket.domain.MOrder;

public interface CustomerAdModule {
	
   public MOrder createOrder(int customerId,int gid);
   
   public boolean commentGood(int cid,int gid,String evaluation);
   
   public boolean commentSaler(int customerId,int salerId,String evaluation );
   
   public boolean complainGood(String name,String poster,String complain);
   
   public Map<String,Object[]> checkGetGood(int cid);
}
