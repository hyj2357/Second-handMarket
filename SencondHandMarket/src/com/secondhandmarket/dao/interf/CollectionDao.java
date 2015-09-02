package com.secondhandmarket.dao.interf;

import java.util.List;

import com.secondhandmarket.domain.Collection;

public interface CollectionDao extends BasicDao{
	 public static String ALIAS = "cl";
	 public static String[] COLUMNS = {"cl.gname","cl.cid","cl.gid"};
	 public static String CLASSNAME = "com.secondhandmarket.domain.Collection";
     
	 public Collection findByClid(int cid);
}
