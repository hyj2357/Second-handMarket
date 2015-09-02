package com.secondhandmarket.dao.interf;

import com.secondhandmarket.domain.Good;

public interface GoodDao extends BasicDao{
	public static String ALIAS = "g";
    public static String[] COLUMNS = {"g.gid","g.price","g.intro","g.isOnline","g.posterId","g.category"};  
	public static String CLASSNAME = "com.secondhandmarket.domain.Good";
        
	public Good findByGid(int gid);
}
