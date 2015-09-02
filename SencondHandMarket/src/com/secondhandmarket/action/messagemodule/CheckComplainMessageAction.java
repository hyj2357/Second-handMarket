package com.secondhandmarket.action.messagemodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.MessageModule;

public class CheckComplainMessageAction extends ActionSupport{
     private int receiver;
     private MessageModule messageModule;
     
     @Override
	public String execute(){
    	this.messageModule.checkComplainMessage(receiver);
        return SUCCESS;
     }

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public MessageModule getMessageModule() {
		return messageModule;
	}

	public void setMessageModule(MessageModule messageModule) {
		this.messageModule = messageModule;
	} 
}
