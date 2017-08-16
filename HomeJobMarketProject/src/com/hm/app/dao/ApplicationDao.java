package com.hm.app.dao;

import javax.management.*;
import org.hibernate.Query;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.hibernate.*;

import com.hm.app.model.Application;
import com.hm.app.model.Job;
import com.hm.app.model.User;
import com.hm.app.util.CreateSession;

import java.util.*;

public class ApplicationDao {

	/*
	 * Apply to Job
	 */
	public Integer apply(Application model) {
		Session session = CreateSession.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			System.out.println("Model " + model.getJobId());
			Integer appId = (Integer) session.save(model);
			System.out.println("App id :" + appId);
			transaction.commit();
			session.close();
			return appId;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception :" + e.getMessage());
			transaction.rollback();
			session.close();
			return 0;
		}

	}

	public List<Integer> getAppliedJob(Integer memberId) {
		Session session = CreateSession.sessionFactory.openSession();
		Query query = session.createQuery(" from com.hm.app.model.Application");
		List<Application> list = query.list();
		Iterator<Application> iterator = list.iterator();
		List<Integer> jobIds = new ArrayList<Integer>();
		while (iterator.hasNext()) {
			Application app = iterator.next();
			User user = app.getApplyBy();
			Job job = app.getJobId();
			if (user.getId() == memberId)
				jobIds.add(job.getId());
			System.out.println("Member " + user.getId() + " " + job.getId());
		}

		session.close();
		return jobIds;

	}
	
	/*Session session = CreateSession.sessionFactory.openSession();
	Query query = session.createQuery("select am.jobId.id from com.hm.app.model.ApplicationModel am "
			+ "where am.apply_by=:memberId");
	
	query.setParameter("memberId", memberId);
	
	List<Integer> list = query.list();

	session.close();
	return list;*/
	

}
