package com.secondhandmarket.tools;

public class HQLSelectTools implements Types{
	 private final static String SELECT = "select",NEW   = "new",FROM = "from",AS   = "as",WHERE= "where",AND  = "and",
			                     MEM  = ".",SPA  = " ",SPT  = ",",STR  = "*",QST  = "?",EQL  = "=",LEFT = "(",
	                             RIGHT= ")";
	 
	 /**
	  * Jun:根据输入的参数名称数组以及参数数据选择需要查询的参数
	  * @param args  参数名称数组
	  * @param argsData  参数数据
	  * @return
	  */
	 public static Args getArgs(String[] args,Object[] argsData){
		 int j=0;
		 for(int i=0;i<args.length;i++)
		   if(argsData[i]!=null)
			   j++;
		 String[] margs = new String[j];
		 Object[] margsData = new Object[j];

		 for(int i=0,k=0;i<argsData.length;i++)
			   if(argsData[i]!=null){
				   margs[k] = args[i];
			       margsData[k] = argsData[i];
			       k++;
			   }
		 
		 Args arg = new Args();
		 arg.setArgs(margs);
		 arg.setArgsData(margsData);
		 
		 return arg;
	 }
/**
 * Jun:根据输入的相关信息返回hql语句
 * @param classname   返回的 List 对象中的对象类型
 * @param selectArgs  要查询的属性
 * @param tables      查询关联到的表
 * @param tablesAlias 表的别名
 * @param args        查询条件参数
 **/
	 public static String toHQLSelectStatement(String classname,String selectArgs[],String tables[],String tablesAlias[],String args[]) throws Exception{
    	 StringBuilder HQL      = new StringBuilder(),
    	               tabs     = new StringBuilder(),
    	               margs    = new StringBuilder();
    	 
    	 if(selectArgs!=null){
    		 if(classname==null)
    			 throw new Exception();
    		 HQL.append(SELECT).append(SPA).append(NEW).append(SPA).append(classname).append(LEFT);// select new class(
    		 for(int i=0;i<selectArgs.length;i++)   //select new class(a,b,...
    			 if(i==selectArgs.length-1)
    				 HQL.append(selectArgs[i]).append(RIGHT).append(SPA);  //select new class(a,b,c)
    			 else
    				 HQL.append(selectArgs[i]).append(SPT);
    	 }
    	
    	 HQL.append(FROM).append(SPA);      //state: from
    	 if(tables==null||tablesAlias==null||tables.length==0||tablesAlias.length==0){
    		 System.out.println("表或别名不能为空");
    		 throw new Exception();
    	 }    	 
    	 if(tables.length!=tablesAlias.length){
    		 System.out.println("表数与别名数不匹配");
    		 throw new Exception();
    	 }
    		 
    	 for(int i=0;i<tables.length;i++){
    		 if(i==tables.length-1)
    			 tabs.append(tables[i]).append(SPA).append(AS).append(SPA).append(tablesAlias[i]).append(SPA);
    		 else
    			 tabs.append(tables[i]).append(SPA).append(AS).append(SPA).append(tablesAlias[i]).append(SPT);
    	 }
    	 
    	 HQL.append(tabs.toString()).append(SPA);  //state: select */a.b,c.e... from t1 as t1,...
    	 	 
    	 if(args!=null){
       	  for(int i=0;i<args.length;i++){
       		 if(i==args.length-1)
       	     	  margs.append(args[i]).append(EQL).append(QST);
       		 else margs.append(args[i]).append(EQL).append(QST).append(SPA).append(AND).append(SPA);
       	  }
       	  if(!(margs.length()==0))
       		 HQL.append(WHERE).append(SPA);
       	  HQL.append(margs.toString());    //select */a.b,c.e... from t1 as t1,... where a.d=?,a.f=?/[null]
       	 }
    	 return HQL.toString();   //return hql
     };
}
