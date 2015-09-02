package com.secondhandmarket.dao.interf;

import java.util.List;

import com.secondhandmarket.domain.Customer;

public interface CustomerDao extends BasicDao{
    public static String ALIAS = "cs";
	public static String[]  COLUMNS= {"cs.cid","cs.name","cs.password","cs.province","cs.city","cs.area","cs.school","cs.phonenumber","cs.authority"};
	public static String CLASSNAME = "Customer";	
	
	public Customer findCidByName(String name);
	public Customer findCustomerByCid(int cid);
	
	/**
	 * Jun:获取随机管理员
	 * <br/>
	 * @param isSuper 0:超级管理员 1:普通管理员 
	 * @return
	 */
	public Customer getRandomAdmin(int isSuper);
}
