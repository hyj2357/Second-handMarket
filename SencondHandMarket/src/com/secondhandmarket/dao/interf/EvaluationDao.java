package com.secondhandmarket.dao.interf;

import com.secondhandmarket.domain.Evaluation;

public interface EvaluationDao extends BasicDao{
	 public static String ALIAS = "e"; 
	 public static String[] COLUMNS = {"e.eid","e.cid","e.content","e.gid"};
	 public static String CLASSNAME = "com.secondhandmarket.domain.Evaluation";
	     
     public Evaluation findByEid(int eid);
}
