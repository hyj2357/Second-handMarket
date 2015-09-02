package com.secondhandmarket.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secondhandmarket.dao.interf.EvaluationDao;
import com.secondhandmarket.domain.Customer;
import com.secondhandmarket.domain.Evaluation;

public class EvaluationDaoImpl extends BasicOperationImpl implements EvaluationDao{

	public boolean create(Object obj) {
	    this.getHibernateTemplate().save( ((Evaluation)obj) );
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

						session.update(((Evaluation)obj)); 

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

						Query query = session.createSQLQuery("DELETE FROM evaluation WHERE eid=?")
								.setInteger(0, ((Evaluation)obj).getEid() );
						query.executeUpdate();
						
						session.getTransaction().commit();
						return null; 
					}
				});		
		return true;
	}

	@Override
	public Evaluation findByEid(int eid) {
        String hql = "from evaluation e where e.eid=?";
        List ls = this.getHibernateTemplate().find(hql, new Object[]{eid});
		return ls.size()==0?null:(Evaluation)ls.get(0);
	}

}
