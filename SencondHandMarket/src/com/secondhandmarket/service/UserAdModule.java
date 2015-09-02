package com.secondhandmarket.service;

import java.util.Map;

import com.secondhandmarket.domain.Customer;

public interface UserAdModule {
	
	public Customer registUser(String name,String password,String school,String phonenumber,String qqnumber);
	
	public boolean complainAdmin(String name,String admin,String complain);
	
	public Customer modifyCustomerInfo(String name,String school,String phonenumber,String qqnumber);

	public Customer modifyPassword(int cid,String password,String newPassword);
	
    public boolean unlockCustomer(int cid,int aid);
    
    /**
     * Jun:用户登录
     * @param name
     * @param password
     * @return
     */
    public boolean login(String name,String password);
    /**
     * Jun:查看用户详细信息
     * @param cid
     * @return
     */
    public Customer checkCustomerInfo(String name);
    
    /**
     * Jun:查看申请注册用户列表
     * @return
     */
    public Map<String,Object[]> checkCustomersRegist();
    
    /**
     * Jun:对申请账号的用户进行通过或拒绝操作
     * @param op  0:拒绝 1:通过
     * @param cid
     * @param aid
     * @return
     */
    public boolean opCustomerRegist(int cid,int aid,int op);
    
    public boolean lockCustomer(int cid,int aid,String reason);   
    
    public boolean addCustomerToAdmin(int cid,int said);
    
    public boolean removeAdminAuthority(int aid,int sid,String reason);
}
