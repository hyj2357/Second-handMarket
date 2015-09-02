package com.secondhandmarket.dao.interf;

import java.util.List;

public interface BasicDao {
    
	public boolean create(Object obj);
    
    public boolean updateObj(Object obj);
    
    public boolean deleteObj(Object obj);
    
	/**
	 * Jun:根据参数生成相应 hql 语句
	 * <br/>SELECT NEW CLASSNAME(selectArgs) FROM tables AS tablesAlias WHERE COLUMNS=argsData
	 * @param selectArgs
	 * @param tables
	 * @param tablesAlias
	 * @param COLUMNS
	 * @param CLASSNAME
	 * @param argsData
	 * @return
	 */
    public List<Object> find(String[] selectArgs,String[] tables,String[] tablesAlias,String[] COLUMNS,String CLASSNAME,Object[] argsData);

}
