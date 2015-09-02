package com.secondhandmarket.tools;

public class HrefTools {
	public static String EQL = "=",QST = "?",LIN="&";
	
	/**
	 * Jun:获取相关 action 的 href
	 * @param actionName 
	 * @param argsNames
	 * @param argsData
	 * @return
	 * @throws Exception
	 */
    public static String toActionHref(String actionName,String[] argsNames,Object[] argsData) throws Exception{
    	StringBuilder href = new StringBuilder(actionName);  //action
    	if(argsNames.length!=argsData.length)
    		throw new Exception();
    	if(argsNames.length!=0){
    		href.append(QST);   // action?
    	    for(int i=0;i<argsNames.length;i++)
    	      if(i==argsNames.length-1)
    	    	  href.append(argsNames[i]).append(EQL).append(argsData[i].toString()); // action?a=1&b=2
    	      else
    	    	  href.append(argsNames[i]).append(EQL).append(argsData[i].toString()).append(LIN);  // action?a=1&   
    	}
    	return href.toString();
    }
}
