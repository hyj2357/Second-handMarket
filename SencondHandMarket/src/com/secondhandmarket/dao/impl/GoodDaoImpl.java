package com.secondhandmarket.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secondhandmarket.dao.interf.GoodDao;
import com.secondhandmarket.domain.BuyerRecord;
import com.secondhandmarket.domain.Good;

public class GoodDaoImpl extends BasicOperationImpl implements GoodDao{

	@Override
	public boolean create(Object obj) {
	    this.getHibernateTemplate().save( ((Good)obj) );
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

						session.update(((Good)obj)); 

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

						Query query = session.createSQLQuery("DELETE FROM good WHERE gid=?")
								.setInteger(0, ((Good)obj).getGid() );
						query.executeUpdate();
						
						session.getTransaction().commit();
						return null; 
					}
				});		
		return true;
	}

	@Override
	public Good findByGid(int gid) {
        String hql = "from good g where g.gid=?";
        List ls = this.getHibernateTemplate().find(hql, new Object[]{gid});
		return ls.size()==0?null:(Good)ls.get(0);
	}

}
