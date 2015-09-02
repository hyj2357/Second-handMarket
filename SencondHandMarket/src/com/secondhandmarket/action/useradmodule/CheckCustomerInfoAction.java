package com.secondhandmarket.action.useradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.domain.Customer;
import com.secondhandmarket.service.UserAdModule;

public class CheckCustomerInfoAction extends ActionSupport{
	private String name,user_school,user_phonenum,user_qqnum,user_confirm;
	private int user_id;	
	private UserAdModule userAdModule;
	
	
	@Override
	public String execute(){
		Customer cs = this.userAdModule.checkCustomerInfo(name);
		user_confirm = cs.getConfirm()==0?"false":"true";
		this.user_id = cs.getCid();
		this.user_phonenum = cs.getPhonenumber();
		this.user_school = cs.getSchool();
		this.user_qqnum = cs.getQqnumber();
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_school() {
		return user_school;
	}

	public void setUser_school(String user_school) {
		this.user_school = user_school;
	}

	public String getUser_phonenum() {
		return user_phonenum;
	}

	public void setUser_phonenum(String user_phonenum) {
		this.user_phonenum = user_phonenum;
	}

	public String getUser_qqnum() {
		return user_qqnum;
	}

	public void setUser_qqnum(String user_qqnum) {
		this.user_qqnum = user_qqnum;
	}

	public String getUser_confirm() {
		return user_confirm;
	}

	public void setUser_confirm(String user_confirm) {
		this.user_confirm = user_confirm;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public UserAdModule getUserAdModule() {
		return userAdModule;
	}

	public void setUserAdModule(UserAdModule userAdModule) {
		this.userAdModule = userAdModule;
	}
}
