package com.secondhandmarket.service;

import java.util.Map;

import com.secondhandmarket.domain.Message;

public interface MessageModule {
    public Map<String,Object[]> checkNormalMessage(int receiver);
    
    public Map<String,Object[]> checkComplainMessage(int receiver);
    
    public boolean replyComplainMessage(int sender,int receiver,String title,String content);
    
    public Message checkMessage(int mid);
}
