package com.secondhandmarket.service.impl;

import java.util.Map;

import com.secondhandmarket.dao.interf.CustomerDao;
import com.secondhandmarket.dao.interf.EvaluationDao;
import com.secondhandmarket.dao.interf.GoodDao;
import com.secondhandmarket.dao.interf.MOrderDao;
import com.secondhandmarket.dao.interf.MessageDao;
import com.secondhandmarket.domain.Customer;
import com.secondhandmarket.domain.Evaluation;
import com.secondhandmarket.domain.Good;
import com.secondhandmarket.domain.MOrder;
import com.secondhandmarket.service.CustomerAdModule;

public class CustomerAdModuleImpl implements CustomerAdModule{
    private MOrderDao morderDao;
    private CustomerDao customerDao;
    private GoodDao goodDao;
    private EvaluationDao evaluationDao;
    private MessageDao messageDao;
    
	@Override
	public MOrder createOrder(int customerId, int gid) {        
		MOrder morder = new MOrder();       
        Customer cs  = this.customerDao.findCustomerByCid(customerId);
        Good gd = this.goodDao.findByGid(gid);

        morder.setBuyer(cs);
        morder.setGd(gd);
        morder.setPrice(gd.getPrice());
        morder.setSaler(gd.getPoster());
        morder.setHasPay(0);
        
        if(gd==null || cs==null)
        	return null;
        morderDao.create(morder);   //创建订单
        
        //给商户发送消息
        String mscontent = "你的商品["+gd.getGname()+"]收到来自用户["+cs.getName()+"]的订单;";
        messageDao.creatMessage("获取新账单",mscontent, cs, gd.getPoster(),0);
		return morder;
	}

	@Override
	public boolean commentGood(int cid,int gid, String content) {
        Customer cs = customerDao.findCustomerByCid(cid);
        Good gd = goodDao.findByGid(gid);
        Evaluation evaluation = new Evaluation();
        
        evaluation.setGd(gd);
        evaluation.setCs(cs);
        evaluation.setContent(content);
        
        this.evaluationDao.create(evaluation);   //发送评价
        //给商户发送消息
        String mscontent = "你的商品["+gd.getGname()+"]收到来自用户["+cs.getName()+"]的评价;";
        messageDao.creatMessage("商品收到新评价",mscontent, cs, gd.getPoster(),0);		
        return true;
	}

	@Override
	public boolean commentSaler(int customerId, int salerId, String evaluation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean complainGood( String name,String poster, String complain) {
        Customer cs = customerDao.findCidByName(name);
        Customer _poster = this.customerDao.findCidByName(poster);
        
        //向管理员发送投诉信息
        messageDao.creatMessage("商品投诉", "投诉内容"+complain, cs, _poster,0);
		return true;
	}

	@Override
	public Map<String, Object[]> checkGetGood(int cid) {
        
		return null;
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

	public GoodDao getGoodDao() {
		return goodDao;
	}

	public void setGoodDao(GoodDao goodDao) {
		this.goodDao = goodDao;
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public EvaluationDao getEvaluationDao() {
		return evaluationDao;
	}

	public void setEvaluationDao(EvaluationDao evaluationDao) {
		this.evaluationDao = evaluationDao;
	}

}
