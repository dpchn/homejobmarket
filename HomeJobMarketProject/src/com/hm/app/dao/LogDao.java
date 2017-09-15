package com.hm.app.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.hm.app.framework.*;
import com.hm.app.model.LogHistory;

@SuppressWarnings("deprecation")
public class LogDao implements LogHibernateModel{
	
	public void  saveLog(LogHistory logHistory){
		Session session = HibernateSessionUtil.getSession();
		session.save(logHistory);
	}
	
	public List<LogHistory> getHistory(int id) {
		Session session = HibernateSessionUtil.getSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from com.hm.app.model.LogHistory where user_id=:id order by created_at asc");
		query.setParameter("id", id);
		return query.getResultList();
	}

}
