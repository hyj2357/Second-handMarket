package com.secondhandmarket.action.useradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.UserAdModule;

public class RegistUserAction extends ActionSupport{
      private String name, password, province, city, area, school, phonenumber,qqnumber,user_registered="false",user_name_conflict="true";
      private UserAdModule userAdModule;
      
      public String execute(){
    	  boolean f = this.userAdModule.registUser(name, password, school, phonenumber,qqnumber)==null;
    	  this.user_registered = f?"false":"true";
    	  this.user_name_conflict=f?"true":"false";
    	  return SUCCESS;
      }

	public String getQqnumber() {
		return qqnumber;
	}

	public void setQqnumber(String qqnumber) {
		this.qqnumber = qqnumber;
	}

	public String getUser_registered() {
		return user_registered;
	}

	public void setUser_registered(String user_registered) {
		this.user_registered = user_registered;
	}

	public String getUser_name_conflict() {
		return user_name_conflict;
	}

	public void setUser_name_conflict(String user_name_conflict) {
		this.user_name_conflict = user_name_conflict;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public UserAdModule getUserAdModule() {
		return userAdModule;
	}

	public void setUserAdModule(UserAdModule userAdModule) {
		this.userAdModule = userAdModule;
	}
}
