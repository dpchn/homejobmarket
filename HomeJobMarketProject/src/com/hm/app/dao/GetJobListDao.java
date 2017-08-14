package com.hm.app.dao;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hm.app.model.JobModel;
import com.hm.app.util.CreateSession;

public class GetJobListDao {
	public static Map<String, Object> fetchAllJob() {
		Session session = CreateSession.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<JobModel> list = session.createQuery("from com.hm.app.model.JobModel").list();
		Map<String, Object> joblist = new HashMap<>();
		for(JobModel l: list) {
			joblist.put("jobId", l.getId());
			joblist.put("jobTitle", l.getJobTitle());
			joblist.put("jobDes", l.getJobDes());
			joblist.put("startDate", l.getStartDate());
			joblist.put("endDate", l.getEndDate());
			joblist.put("payPerHour", l.getPayPerHour());
			joblist.put("postedBy", l.getPostedBy());
			
		}
		
		transaction.commit();
		session.close();
		return joblist;
	
	}

}
