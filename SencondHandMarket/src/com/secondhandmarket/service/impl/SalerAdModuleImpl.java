package com.secondhandmarket.service.impl;

import java.util.List;
import java.util.Map;

import com.secondhandmarket.dao.interf.CustomerDao;
import com.secondhandmarket.dao.interf.GoodDao;
import com.secondhandmarket.dao.interf.MessageDao;
import com.secondhandmarket.domain.Customer;
import com.secondhandmarket.domain.Good;
import com.secondhandmarket.service.SalerAdModule;

public class SalerAdModuleImpl implements SalerAdModule{
    private GoodDao  goodDao;
    private CustomerDao customerDao;
    private MessageDao messageDao;
    
	@Override
	public boolean offlineGood( int gid) {
        Good gd = goodDao.findByGid(gid);
       
        gd.setIsOnline(2);   //设置状态码
        this.goodDao.updateObj(gd);   //更新数据，下线商品
		return true;
	}

	@Override
	public boolean postGood(float price, String intro, String itemname,int isOnline,String category, String name) {
        Good gd = new Good();
        Customer cs = this.customerDao.findCidByName(name);
        
        gd.setPrice(price);
        gd.setIntro(intro);
        gd.setIsOnline(0);
        gd.setPoster(cs);
        gd.setGname(itemname);
        gd.setCategory(category);
        
        this.customerDao.create(gd);  //创建商品
        this.messageDao.creatMessage("用户上线商品审核请求", 
        		                     "用户"+cs.getName()+"请求上线商品["+"id:"+gd.getGid()+" 名称:"+gd.getGname()+"]", 
        		                      cs, 
        		                      this.customerDao.getRandomAdmin(1), 0);
		return true;
	}
	

	@Override
	public boolean onlineGood(int posterId, int gid) {
        Good gd = this.goodDao.findByGid(gid);
        Customer cs = this.customerDao.findCustomerByCid(posterId);
        
        if(gd.getPoster().getCid()!=cs.getCid())
        	return false;
        gd.setIsOnline(0);
        this.goodDao.updateObj(gd);
        this.messageDao.creatMessage("用户上线商品审核请求", 
                "用户"+cs.getName()+"请求上线商品["+"id:"+gd.getGid()+" 名称:"+gd.getGname()+"]", 
                 cs, 
                 this.customerDao.getRandomAdmin(1), 0);
		return false;
	}

	@Override
	public boolean modifyGoodInfo(int gid,float price, String intro, String itemname, String category, String name) {
        Good gd = goodDao.findByGid(gid);
        Customer cs = this.customerDao.findCidByName(name);
        
        gd.setPrice(price);
        gd.setIntro(intro);
        gd.setGname(itemname);
        gd.setCategory(category);
        gd.setIsOnline(1);
        this.goodDao.updateObj(gd);
        this.messageDao.creatMessage("用户修改商品再上线审核请求", 
                "用户"+cs.getName()+"请求修改商品再上线["+"id:"+gd.getGid()+" 名称:"+gd.getGname()+"]", 
                 cs, 
                 this.customerDao.getRandomAdmin(1), 0);
		return true;
	}


	@Override
	public Map<String, Object[]> checkPostGoodList(int posterId) {
        List ls = this.goodDao.find(null, 
        		                    new String[]{"Good"}, 
        		                    new String[]{GoodDao.ALIAS}, 
        		                    GoodDao.COLUMNS, 
        		                    GoodDao.CLASSNAME, 
        		                    new Object[]{null,null,null,null,new Integer(posterId),null});
		return null;
	}

	@Override
	public Map<String, Object[]> checkCustomerPostGood(int isAdmin) {
		Integer isOnline = isAdmin==0?null:new Integer(1);   //如果为管理员查看，则查看所有商品，包括未上线商品
		
        List ls = this.goodDao.find(null, 
                new String[]{"Good"}, 
                new String[]{GoodDao.ALIAS}, 
                GoodDao.COLUMNS, 
                GoodDao.CLASSNAME, 
                new Object[]{null,null,null,isOnline,null,null});
        return null;
	}

	@Override
	public boolean offlineGoodByAdmin(int gid, int aid, String reason) {
        Good gd = this.goodDao.findByGid(gid);
        Customer admin = this.customerDao.findCustomerByCid(aid);
        //如果管理员权限正常
        if(admin.getAuthority()==3){
        	gd.setIsOnline(2);
        	this.goodDao.updateObj(gd);
            this.messageDao.creatMessage("管理员下线商品", 
                    "管理员"+admin.getName()+"下线你的商品["+"id:"+gd.getGid()+" 名称:"+gd.getGname()+"]\n下线理由:"+reason, 
                     admin, 
                     gd.getPoster(), 0);
        	return true;
        }
		return false;
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

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
}
