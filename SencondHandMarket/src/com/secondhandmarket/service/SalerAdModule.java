package com.secondhandmarket.service;

import java.util.Map;

public interface SalerAdModule {
	
      public boolean offlineGood(int gid);
      
      public boolean onlineGood(int posterId,int gid);
      
  	  public boolean postGood(float price, String intro, String itemname,int isOnline,String category, String name);

  	  public boolean modifyGoodInfo(int gid,float price, String intro, String itemname,String category, String name);
      
      public Map<String,Object[]> checkPostGoodList(int posterId);

      /**
       * 
       * @param isAdmin 0为管理员，1为普通用户
       * @return
       */
      public Map<String,Object[]> checkCustomerPostGood(int isAdmin);
      
      public boolean offlineGoodByAdmin(int gid,int aid,String reason);
}
