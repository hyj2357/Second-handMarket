package com.secondhandmarket.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.secondhandmarket.dao.interf.CollectionDao;
import com.secondhandmarket.dao.interf.CustomerDao;
import com.secondhandmarket.dao.interf.EvaluationDao;
import com.secondhandmarket.dao.interf.GoodDao;
import com.secondhandmarket.domain.Collection;
import com.secondhandmarket.domain.Customer;
import com.secondhandmarket.domain.Evaluation;
import com.secondhandmarket.domain.Good;
import com.secondhandmarket.service.GoodModule;

public class GoodModuleImpl implements GoodModule{
    private GoodDao goodDao;
    private CustomerDao customerDao;
    private CollectionDao collectionDao;
    private EvaluationDao evaluationDao;
    
	@Override
	public Map<String, Object[]> searchGood(float price, String intro,int isOnline, String category) {
		List ls = this.goodDao.find(null, 
				                    new String[]{"good"}, 
				                    new String[]{GoodDao.ALIAS}, 
				                    GoodDao.COLUMNS, 
				                    GoodDao.CLASSNAME, 
				                    new Object[]{null,price,intro,isOnline,null,category});
		return null;
	}

	@Override
	public List searchGoodByPoster(String poster) {
		Customer cs = this.customerDao.findCidByName(poster);
		List ls = this.goodDao.find(null, 
				                    new String[]{"good"}, 
				                    new String[]{GoodDao.ALIAS}, 
				                    GoodDao.COLUMNS, 
				                    GoodDao.CLASSNAME, 
                                    new Object[]{null,null,null,new Integer(cs.getCid()),null});
        return ls;
	}

	@Override
	public Good checkGoodInfo(int gid) {
		return this.goodDao.findByGid(gid);
	}

	@Override
	public Map<String, Evaluation> checkGoodComments(int gid) {
        List ls = this.evaluationDao.find(null, 
        		                          new String[]{"evaluation"}, 
        		                          new String[]{EvaluationDao.ALIAS}, 
        		                          EvaluationDao.COLUMNS, 
        		                          EvaluationDao.CLASSNAME, 
        		                          new Object[]{null,null,null,gid});
		return null;
	}

	@Override
	public boolean collectGood(String name, int gid) {
		Collection collection = new Collection();
		Customer cs = this.customerDao.findCidByName(name);
		Good gd = this.goodDao.findByGid(gid);
		
		collection.setCs(cs);
		collection.setGd(gd);
		collection.setGname(gd.getGname());
		
        this.collectionDao.create(collection);
		return true;
	}

	public GoodDao getGoodDao() {
		return goodDao;
	}

	public void setGoodDao(GoodDao goodDao) {
		this.goodDao = goodDao;
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public CollectionDao getCollectionDao() {
		return collectionDao;
	}

	public void setCollectionDao(CollectionDao collectionDao) {
		this.collectionDao = collectionDao;
	}

	public EvaluationDao getEvaluationDao() {
		return evaluationDao;
	}

	public void setEvaluationDao(EvaluationDao evaluationDao) {
		this.evaluationDao = evaluationDao;
	}

	@Override
	public List checkCollectGoods(String name) {
        Customer cs  = this.customerDao.findCidByName(name);
        List goodList = new ArrayList<Good>();
        List<Object> ls = this.collectionDao.find(null, 
        		                new String[]{"collection"}, 
        		                new String[]{CollectionDao.ALIAS}, 
        		                CollectionDao.COLUMNS, 
        		                CollectionDao.CLASSNAME, 
        		                new Object[]{null,new Integer(cs.getCid()),null});
        for(Object gd:ls){
        	Good g = (Good)this.goodDao.find(null, 
        			                   new String[]{"good"}, 
        			                   new String[]{GoodDao.ALIAS}, 
        			                   GoodDao.COLUMNS, 
        			                   GoodDao.CLASSNAME, 
        			                   new Object[]{new Integer(((Good)gd).getGid()),null,null,null,null,null}).get(0);
            goodList.add(g);
        }
		return goodList;
	}

	@Override
	public List checkGoodsByClass(String category) {
        List ls = this.goodDao.find(null, 
        		                    new String[]{"good"}, 
        		                    new String[]{GoodDao.ALIAS}, 
        		                    GoodDao.COLUMNS, 
        		                    GoodDao.CLASSNAME, 
        		                    new Object[]{null,null,null,null,null,category});
		return ls;
	}

}
