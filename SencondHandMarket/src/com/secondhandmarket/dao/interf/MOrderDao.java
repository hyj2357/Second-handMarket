package com.secondhandmarket.dao.interf;

import java.util.List;

import com.secondhandmarket.domain.MOrder;

public interface MOrderDao extends BasicDao{
	 public static String ALIAS = "mo";
     public static String[] COLUMNS={"mo.hasPay","mo.gid","mo.price","mo.buyerId","mo.salerId"};
     public static String CLASSNAME = "com.secondhandmarket.domain.MOrder";
     
	 public MOrder findByOid(int oid);
}
