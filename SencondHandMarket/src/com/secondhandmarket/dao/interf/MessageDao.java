package com.secondhandmarket.dao.interf;

import java.sql.Timestamp;
import java.util.List;

import com.secondhandmarket.domain.Customer;
import com.secondhandmarket.domain.Message;

public interface MessageDao extends BasicDao{
	public static String ALIAS = "m";
    public static String[] COLUMNS = {"m.mid","m.title","m.content","m.sender","m.receiver","m.mstime","m.category"};
	public static String CLASSNAME="com.secondhandMarket.domain.Message";
        
    public Message findByMid(int mid);
    public boolean creatMessage(String title,String content,Customer sender,Customer receiver,int category);
}
