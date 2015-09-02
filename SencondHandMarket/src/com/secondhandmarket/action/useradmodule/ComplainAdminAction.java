package com.secondhandmarket.action.useradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.UserAdModule;

public class ComplainAdminAction extends ActionSupport{
   private String name,admin,complain,upload="false";
   private UserAdModule userAdModule;
   
   @Override
public String execute(){
	   upload = this.userAdModule.complainAdmin(name, admin, complain)?"true":"false";
	   return SUCCESS;
   }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAdmin() {
	return admin;
}

public void setAdmin(String admin) {
	this.admin = admin;
}

public String getUpload() {
	return upload;
}

public void setUpload(String upload) {
	this.upload = upload;
}

public String getComplain() {
	return complain;
}

public void setComplain(String complain) {
	this.complain = complain;
}

public UserAdModule getUserAdModule() {
	return userAdModule;
}

public void setUserAdModule(UserAdModule userAdModule) {
	this.userAdModule = userAdModule;
}
   
   
}
