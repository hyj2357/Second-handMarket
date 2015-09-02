package com.secondhandmarket.action.messagemodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.MessageModule;

public class CheckMessageAction extends ActionSupport{
      private int mid;
      private MessageModule messageModule;
      
      @Override
	public String execute(){
    	  this.messageModule.checkMessage(mid);
    	  return SUCCESS;
      }

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public MessageModule getMessageModule() {
		return messageModule;
	}

	public void setMessageModule(MessageModule messageModule) {
		this.messageModule = messageModule;
	}
}
