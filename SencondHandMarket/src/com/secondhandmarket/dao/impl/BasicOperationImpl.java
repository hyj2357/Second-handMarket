package com.secondhandmarket.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secondhandmarket.tools.Args;
import com.secondhandmarket.tools.HQLSelectTools;

public class BasicOperationImpl extends HibernateDaoSupport{

    public List<Object> find(String[] selectArgs,String[] tables,String[] tablesAlias,String[] COLUMNS,String CLASSNAME,Object[] argsData){
		Args args = HQLSelectTools.getArgs(COLUMNS, argsData);
		String hql = "";
        try {
			hql += HQLSelectTools.toHQLSelectStatement(CLASSNAME,selectArgs, tables, tablesAlias, args.getArgs()); //获取hql查询语句
		} catch (Exception e) {
			e.printStackTrace();
		}        
        List ls = this.getHibernateTemplate().find(hql, args.getArgsData());   //hql查询
		return ls;	
    }
}
