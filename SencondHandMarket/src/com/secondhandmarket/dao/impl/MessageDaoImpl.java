package com.secondhandmarket.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.secondhandmarket.dao.interf.MessageDao;
import com.secondhandmarket.domain.BuyerRecord;
import com.secondhandmarket.domain.Customer;
import com.secondhandmarket.domain.Good;
import com.secondhandmarket.domain.Message;

public class MessageDaoImpl extends BasicOperationImpl implements MessageDao{

	@Override
	public boolean create(Object obj) {
	    this.getHibernateTemplate().save( ((Message)obj) );
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

						session.update(((Message)obj)); 

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

						Query query = session.createSQLQuery("DELETE FROM message WHERE mid=?")
								.setInteger(0, ((Message)obj).getMid() );
						query.executeUpdate();
						
						session.getTransaction().commit();
						return null; 
					}
				});		
		return true;
	}

	@Override
	public Message findByMid(int mid) {
        String hql = "from message ms where ms.mid=?";
        List ls = this.getHibernateTemplate().find(hql, new Object[]{mid});
		return ls.size()==0?null:(Message)ls.get(0);
	}

	@Override
	public boolean creatMessage(String title, String content, Customer sender,Customer receiver,int category) {
        Message ms = new Message();
        
        ms.setTitle(title);
        ms.setContent(content);
        ms.setSender(sender);
        ms.setReceiver(receiver);
        ms.setMstime(new Timestamp((new Date()).getTime()));
        ms.setCategory(category);
        
        this.getHibernateTemplate().save(ms);       
		return true;
	}

}
