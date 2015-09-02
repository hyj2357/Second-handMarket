package com.secondhandmarket.service.impl;

import java.util.List;
import java.util.Map;

import com.secondhandmarket.dao.interf.CustomerDao;
import com.secondhandmarket.dao.interf.GoodDao;
import com.secondhandmarket.dao.interf.MOrderDao;
import com.secondhandmarket.dao.interf.MessageDao;
import com.secondhandmarket.domain.Customer;
import com.secondhandmarket.domain.MOrder;
import com.secondhandmarket.service.OrderModule;

public class OrderModuleImpl implements OrderModule{
	
	private GoodDao goodDao;
	private MOrderDao morderDao;
	private CustomerDao customerDao;
	private MessageDao messageDao;
	
	@Override
	public boolean modifyOrderPrice(int salerId, int oid, float price) {
        MOrder morder = morderDao.findByOid(oid);
        
        if(salerId!=morder.getGd().getPoster().getCid())  //当前修改价格者非订单商家，返回false
        	return false;
        
        morder.setPrice(price);
        this.morderDao.updateObj(morder);   //更新订单
        return true;
	}

	@Override
	/**
	 * remain to do
	 */
	public boolean payOrder() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelOrder(int buyerId, int oid) {
		Customer cs = this.customerDao.findCustomerByCid(buyerId);
        MOrder morder = this.morderDao.findByOid(oid);
        if(morder.getBuyer().getCid()!=buyerId)   //如果非用户本人操作，返回false
        	return false;
        if(morder.getHasPay()==1)    //如果订单已经支付，返回false
		   return false;
        messageDao.creatMessage("用户取消订单通知", "用户"+cs.getName()+"取消了订单[订单信息: id:"+morder.getOid()+" 名称:"+morder.getGname()+"];", cs, morder.getSaler(), 0);
        morderDao.deleteObj(morder);  //删除订单
        return true;

	}

	@Override
	public Map<String, Object[]> checkGetOrder(int salerId) {
        List ls = morderDao.find(null, 
        		                 new String[]{"morder"}, 
                                 new String[]{MOrderDao.ALIAS}, 
                                 MOrderDao.COLUMNS, 
                                 MOrderDao.CLASSNAME, 
                                 new Object[]{null,null,null,null,new Integer(salerId)});
		return null;
	}

	@Override
	public MOrder checkOrderInfo(int oid) {
		return this.morderDao.findByOid(oid);
	}

	@Override
	public Map<String, Object[]> checkSendOrder(int buyerId) {
        List ls = morderDao.find(null, 
                                 new String[]{"morder"}, 
                                 new String[]{MOrderDao.ALIAS}, 
                                 MOrderDao.COLUMNS, 
                                 MOrderDao.CLASSNAME, 
                                 new Object[]{null,null,null,new Integer(buyerId),null});
        
        return null;
}

	public GoodDao getGoodDao() {
		return goodDao;
	}

	public void setGoodDao(GoodDao goodDao) {
		this.goodDao = goodDao;
	}

	public MOrderDao getMorderDao() {
		return morderDao;
	}

	public void setMorderDao(MOrderDao morderDao) {
		this.morderDao = morderDao;
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

}
