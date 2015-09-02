package com.secondhandmarket.service;

import java.util.List;
import java.util.Map;

import com.secondhandmarket.domain.Evaluation;
import com.secondhandmarket.domain.Good;

public interface GoodModule {
	
      public Map<String, Object[]> searchGood(float price,String intro,int isOnline,String category);
      
      public List searchGoodByPoster(String poster);
      
      public Good checkGoodInfo(int gid);

      public Map<String,Evaluation> checkGoodComments(int gid);
      
      public boolean collectGood(String name,int gid);
      
      public List checkCollectGoods(String name);
      
      public List checkGoodsByClass(String category);
}
