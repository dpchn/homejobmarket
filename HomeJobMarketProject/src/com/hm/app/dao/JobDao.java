package com.hm.app.dao;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hm.app.model.Job;
import com.hm.app.util.CreateSession;

public class JobDao {
	/*
	 * Create New Job
	 */
	public Integer add(Job object) {
		Session session = CreateSession.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("Job Dao...");

		try {
			Integer id = (Integer) session.save(object);
			transaction.commit();
			session.close();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			session.close();
			return 0;
		}
	}

	/*
	 * Find Job By id
	 */
	public Job findJob(Integer jobId) {
		Session session = CreateSession.sessionFactory.openSession();
		Job jobModel = (Job) session.get(Job.class, jobId);
		session.close();
		return jobModel;
	}

	/*
	 * Get all job list
	 */
	public Map<Object, Object> fetchAllJob(List jobIds) {
		Session session = CreateSession.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Job> list = session.createQuery("from com.hm.app.model.Job").list();
		Map<Object, Object> joblist = new HashMap<>();
		for (Job l : list) {
			if (!jobIds.contains(l.getId())) {
				Map obj = new HashMap<>();
				obj.put("jobId", l.getId());
				obj.put("jobTitle", l.getJobTitle());
				obj.put("jobDes", l.getJobDes());
				obj.put("startDate", l.getStartDate());
				obj.put("endDate", l.getEndDate());
				obj.put("payPerHour", l.getPayPerHour());
				obj.put("postedBy", l.getPostedBy());
				joblist.put(l.getId(), obj);
			}
		}

		transaction.commit();
		session.close();
		return joblist;

	}

	/*
	 * 
	 * Query<JobModel> query = session.
	 * createQuery("from com.hm.app.model.JobModel jm where  jm.id not in :jobIds");
	 * 
	 * query.setParameterList("jobIds", jobIds);
	 * 
	 * List<JobModel> list = query.list();
	 * 
	 * Map<Object, Object> joblist = new HashMap<>(); for(JobModel l: list) {
	 * Map<String,Object> obj = new HashMap<>(); obj.put("jobId", l.getId());
	 * obj.put("jobTitle", l.getJobTitle()); obj.put("jobDes", l.getJobDes());
	 * obj.put("startDate", l.getStartDate()); obj.put("endDate", l.getEndDate());
	 * obj.put("payPerHour", l.getPayPerHour()); obj.put("postedBy",
	 * l.getPostedBy()); joblist.put(l.getId(), obj); }
	 */

}
