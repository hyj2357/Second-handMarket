package com.secondhandmarket.action.messagemodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.MessageModule;

public class CheckNormalMessageAction extends ActionSupport{

	private int receiver;
	private MessageModule messageModule;
	
	public String execute(){
		this.messageModule.checkNormalMessage(receiver);
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
