package com.secondhandmarket.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secondhandmarket.dao.interf.CustomerDao;
import com.secondhandmarket.domain.BuyerRecord;
import com.secondhandmarket.domain.Customer;
import com.secondhandmarket.tools.Args;
import com.secondhandmarket.tools.HQLSelectTools;

public class CustomerDaoImpl extends BasicOperationImpl implements CustomerDao{

	@Override
	public boolean create(Object obj) {
	    this.getHibernateTemplate().save( ((Customer)obj) );
		return true;
	}

	@Override
	public boolean updateObj(final Object obj) {
		//调用 Hibernate 模版更新对象
	    //this.getHibernateTemplate().update(nt);
		this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session) throws HibernateException,
					SQLException {

						session.setFlushMode(FlushMode.AUTO); 

						session.update(((Customer)obj)); 

						session.flush(); 

						return null; 
					}
		});
		return true;
	}

	@Override
	public boolean deleteObj(final Object obj) {
		//调用 Hibernate 模版删除对象
	    //this.getHibernateTemplate().delete(nt);
		this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						session.setFlushMode(FlushMode.AUTO);
						session.beginTransaction();

						Query query = session.createSQLQuery("DELETE FROM customer WHERE cid=?")
								.setInteger(0, ((Customer)obj).getCid() );
						query.executeUpdate();
						
						session.getTransaction().commit();
						return null; 
					}
				});		
		return true;
	}

	@Override
	public Customer findCidByName(String name) {
        String hql = "from customer cs where cs.name=?";
        List ls = this.getHibernateTemplate().find(hql, new Object[]{name});
        return ls.size()==0?null:(Customer)ls.get(0);
	}
	
	@Override
	public Customer findCustomerByCid(int cid){
		String hql = "from customer cs where cs.cid=?";
		List ls = this.getHibernateTemplate().find(hql, new Object[]{cid});
		return ls.size()==0?null:(Customer)ls.get(0);
	}

	@Override
	public Customer getRandomAdmin(int isSuper) {
        String hql = "";
        Integer authority = isSuper==0?new Integer(5):new Integer(3);
        List ls = this.find(new String[]{"cid"}, 
        		            new String[]{"customer"}, 
        		            new String[]{this.ALIAS}, 
        		            this.COLUMNS, 
        		            this.CLASSNAME, 
        		            new Object[]{null,null,null,null,null,null,null,null,authority});
		int id = (int)(Math.random()*ls.size());
        return (Customer)ls.get(id-1);
	}
}
