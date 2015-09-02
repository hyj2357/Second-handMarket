package com.secondhandmarket.service.impl;

import java.util.List;
import java.util.Map;

import com.secondhandmarket.dao.interf.CustomerDao;
import com.secondhandmarket.dao.interf.MessageDao;
import com.secondhandmarket.domain.Customer;
import com.secondhandmarket.service.UserAdModule;

public class UserAdModuleImpl implements UserAdModule{
    private CustomerDao customerDao;
    private MessageDao messageDao;
    
	@Override
	public Customer registUser(String name, String password, String school, String phonenumber,String qqnumber) {
        Customer cs = new Customer();        
        cs.setName(name);
        cs.setPassword(password);
        cs.setSchool(school);
        cs.setPhonenumber(phonenumber);
        cs.setQqnumber(qqnumber);
        cs.setAuthority(0);    //处于申请状态
        cs.setConfirm(0);
        
        if(this.customerDao.findCidByName(name)!=null)    //如果当前用户名已被用，返回null
        	return null;                
        this.customerDao.create(cs);
        this.messageDao.creatMessage("新用户注册审核请求", 
                "用户[id:"+cs.getCid()+" "+cs.getName()+"]", 
                 cs, 
                 this.customerDao.getRandomAdmin(1), 0);
		return cs;
	}

	@Override
	public boolean complainAdmin(String name, String admin, String complain) {
		Customer cs  = this.customerDao.findCidByName(name);
		Customer _admin = this.customerDao.findCidByName(admin);
        this.messageDao.creatMessage("用户投诉管理员", 
                "用户[id:"+cs.getCid()+" "+cs.getName()+"]投诉管理员[id:"+
                 _admin.getCid()+" "+_admin.getName()+"]\n"+
                "投诉信息:"+complain, 
                 cs, 
                 _admin, 0);
		return true;
	}

	@Override
	public Customer modifyCustomerInfo(String name, String school,String phonenumber,String qqnumber) {
        Customer cs = this.customerDao.findCidByName(name);
        cs.setName(name);
        cs.setSchool(school);
        cs.setPhonenumber(phonenumber);
        cs.setQqnumber(qqnumber);
        
        this.customerDao.updateObj(cs);
		return cs;
	}

	@Override
	public Customer modifyPassword(int cid, String password, String newPassword) {
        Customer cs = this.customerDao.findCustomerByCid(cid);
        if(!cs.getPassword().equals(password))  //输入密码与原密码不匹配，返回false
        	return null;
        cs.setPassword(newPassword);
        this.customerDao.updateObj(cs);
		return cs;
	}

	@Override
	public boolean unlockCustomer(int cid,int aid) {
        Customer admin = this.customerDao.findCustomerByCid(aid);
        if(admin.getAuthority()!=3)    //如果当前管理员无权限，返回false
        	return false;
        Customer cs = this.customerDao.findCustomerByCid(cid);
        if(cs.getAuthority()==2) {
          cs.setAuthority(1);
          this.customerDao.updateObj(cs);
          this.messageDao.creatMessage("管理员解锁提示", 
                  "管理员[id:"+admin.getCid()+" "+admin.getName()+"]已解锁你的账号;",
                   admin, 
                   cs, 0);
        }       
		return true;
	}

	@Override
	public Customer checkCustomerInfo(String name) {        
		return this.customerDao.findCidByName(name);
	}

	@Override
	public Map<String, Object[]> checkCustomersRegist() {
        List ls = this.customerDao.find(null, 
        		                        new String[]{"customer"}, 
        		                        new String[]{CustomerDao.ALIAS}, 
        		                        CustomerDao.COLUMNS, 
        		                        CustomerDao.CLASSNAME, 
        		                        new Object[]{null,null,null,null,null,null,null,null,new Integer(0)});
		return null;
	}

	@Override
	public boolean opCustomerRegist(int cid,int aid,int op) {
		Customer admin = this.customerDao.findCustomerByCid(aid);
		if(admin.getAuthority()!=3)
			return false;
        Customer cs = this.customerDao.findCustomerByCid(cid);
		cs.setAuthority(op);
		this.customerDao.updateObj(cs);
        this.messageDao.creatMessage("管理员审核账号申请提示", 
                                     "管理员[id:"+admin.getCid()+" "+admin.getName()+"]"+
                                     (op==0?"未通过你的新账号申请":"通过了你的账号申请"),
                                     admin, 
                                     cs, 0);
        return true;
	}
	
	@Override
	public boolean lockCustomer(int cid, int aid, String reason) {
        Customer admin  = this.customerDao.findCustomerByCid(aid);
        if(admin.getAuthority()!=3)
        	return false;
        Customer cs = this.customerDao.findCustomerByCid(cid);
        cs.setAuthority(2);
        this.customerDao.updateObj(cs);   //更新数据
        this.messageDao.creatMessage("管理员封禁账号权限提示", 
                "管理员[id:"+admin.getCid()+" "+admin.getName()+"]"+
                "封禁了你的账号权限，封禁理由:"+reason,
                admin, 
                cs, 0);
		return true;
	}

	@Override
	public boolean addCustomerToAdmin(int cid, int said) {
        Customer sadmin = this.customerDao.findCustomerByCid(said);
        Customer cs = this.customerDao.findCustomerByCid(cid);
        if(sadmin.getAuthority()!=5)
        	return false;
        cs.setAuthority(3);
        this.customerDao.updateObj(cs);   //更新数据
        this.messageDao.creatMessage("管理员账号权限添加提示", 
                "超级管理员[id:"+sadmin.getCid()+" "+sadmin.getName()+"]"+
                "提升你的账号权限为普通管理员;",
                sadmin, 
                cs, 0);
		return true;
	}

	@Override
	public boolean removeAdminAuthority(int aid, int sid, String reason) {
        Customer sadmin  = this.customerDao.findCustomerByCid(aid);
        if(sadmin.getAuthority()!=5)
        	return false;
        Customer cs = this.customerDao.findCustomerByCid(aid);
        cs.setAuthority(1);
        this.customerDao.updateObj(cs);   //更新数据
        this.messageDao.creatMessage("普通管理员账号权限移除提示", 
                "超级管理员[id:"+sadmin.getCid()+" "+sadmin.getName()+"]"+
                "移除了你的账号普通管理员权限，封禁理由:"+reason,
                sadmin, 
                cs, 0);
		return true;
	}
	
	@Override
	public boolean login(String name, String password) {
        List ls = this.customerDao.find(null, 
        		              new String[]{"Customer"}, 
        		              new String[]{CustomerDao.ALIAS}, 
        		              CustomerDao.COLUMNS, CustomerDao.CLASSNAME, 
        		              new Object[]{null,name,password,null,null,null,null,null,null});    
		return ls.size()==0?false:true;
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
