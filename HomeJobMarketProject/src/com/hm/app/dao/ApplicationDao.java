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
	
	
	

	/*
	 * 
	 * Get Applied Job list
	 */
	public List<Integer> getAppliedJob(Integer memberId) {
		Session session = CreateSession.sessionFactory.openSession();
		Query query = session.createQuery("from com.hm.app.model.Application where apply_by ="+memberId+"");
		/*Query q = session.createQuery("from com.hm.app.model.Job  where jobId not IN (:applist)");
		List<Application> ll = query.list();
		q.setParameter("applist", ll);*/
		List<Application> app =query.getResultList();
		List<Integer> jobList = new ArrayList<>();
		app.stream().forEach(x->jobList.add(x.getJobId().getId()));
		session.close();
		return jobList;
	}
	
	
	
	
/*	void test(Integer id) {
		Session session = CreateSession.sessionFactory.openSession();
		Query query = session.createQuery("from com.hm.app.model.Application where apply_by ="+id+"");
		List<Application> list = query.list();
		List<Job> l = new ArrayList<>();
		list.stream().forEach(x->{
			System.out.println("Job id "+x.getJobId());
			l.add(x.getJobId());
		});
		
	}
	
public static void main(String[] args) {
	new ApplicationDao().test(3);
}*/
}
