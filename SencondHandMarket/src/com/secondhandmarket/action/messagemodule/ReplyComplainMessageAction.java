package com.secondhandmarket.action.messagemodule;

import com.opensymphony.xwork2.ActionSupport;
import com.secondhandmarket.service.MessageModule;

public class ReplyComplainMessageAction extends ActionSupport{
	private int sender,receiver;
	private String title,content;
	private MessageModule messageModule;
	
	@Override
	public String execute(){
		this.messageModule.replyComplainMessage(sender, receiver, title, content);
		return SUCCESS;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MessageModule getMessageModule() {
		return messageModule;
	}

	public void setMessageModule(MessageModule messageModule) {
		this.messageModule = messageModule;
	}	
}
