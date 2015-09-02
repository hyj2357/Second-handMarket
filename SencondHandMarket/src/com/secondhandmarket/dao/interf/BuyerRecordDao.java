package com.secondhandmarket.dao.interf;

import com.secondhandmarket.domain.BuyerRecord;

public interface BuyerRecordDao extends BasicDao{
	 public static String[] COLUMNS = {"b.hasPay","b.gname","b.gid","b.price","b.buyerId","b.salerId"};
	 public static String CLASSNAME = "com.secondhandmarket.domain.BuyerRecord";
      
     public BuyerRecord findByBid(int bid);
}
