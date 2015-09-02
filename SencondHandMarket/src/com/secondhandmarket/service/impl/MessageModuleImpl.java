package com.secondhandmarket.service.impl;

import java.util.List;
import java.util.Map;

import com.secondhandmarket.dao.interf.CustomerDao;
import com.secondhandmarket.dao.interf.MessageDao;
import com.secondhandmarket.domain.Message;
import com.secondhandmarket.service.MessageModule;

public class MessageModuleImpl implements MessageModule{
    private MessageDao messageDao;
    private CustomerDao customerDao;
	
	@Override
	public Map<String, Object[]> checkNormalMessage(int receiver) {
        List ls = this.messageDao.find(null, 
        		                       new String[]{"message"}, 
        		                       new String[]{MessageDao.ALIAS}, 
        		                       MessageDao.COLUMNS, 
        		                       MessageDao.CLASSNAME, 
        		                       new Object[]{null,null,null,null,new Integer(receiver),null,new Integer(0)});
		return null;
	}

	@Override
	public Map<String, Object[]> checkComplainMessage(int receiver) {
        List ls = this.messageDao.find(null, 
                new String[]{"message"}, 
                new String[]{MessageDao.ALIAS}, 
                MessageDao.COLUMNS, 
                MessageDao.CLASSNAME, 
                new Object[]{null,null,null,null,new Integer(receiver),null,new Integer(1)});
		return null;
	}

	@Override
	public boolean replyComplainMessage(int sender, int receiver, String title,String content) {
        messageDao.creatMessage(title, content, customerDao.findCustomerByCid(sender), customerDao.findCustomerByCid(receiver),1);
		return true;
	}

	@Override
	public Message checkMessage(int mid) {
		return messageDao.findByMid(mid);
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}
