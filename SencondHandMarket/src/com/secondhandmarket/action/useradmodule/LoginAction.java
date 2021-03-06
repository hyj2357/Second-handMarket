package com.secondhandmarket.action.useradmodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.UserAdModule;

public class LoginAction extends ActionSupport{
	private String name,password,user_registered="false",logged="false";
	private UserAdModule userAdModule;
	
	@Override
	public String execute(){
		switch(this.userAdModule.login(name, password)){
		 case 0:{
			this.logged = "false";
			this.user_registered  = "false";
			break;
		 }
		 case 1:{
			this.logged = "false";
			this.user_registered = "true";
			break;
		 }
		 case 2:{
			this.logged = "true";
			this.user_registered = "true";
			break;	
		 }
		};
		return SUCCESS;
	}

	public String getUser_registered() {
		return user_registered;
	}

	public void setUser_registered(String user_registered) {
		this.user_registered = user_registered;
	}

	public String getLogged() {
		return logged;
	}

	public void setLogged(String logged) {
		this.logged = logged;
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

	public UserAdModule getUserAdModule() {
		return userAdModule;
	}

	public void setUserAdModule(UserAdModule userAdModule) {
		this.userAdModule = userAdModule;
	}
}
