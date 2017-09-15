package com.hm.app.dao;

import java.util.*;
import org.hibernate.*;
import com.hm.app.framework.HibernateSessionUtil;
import com.hm.app.model.*;
import org.hibernate.Query;

public class JobDao {
	/**********************************************************************
	 * Create New Job
	 ***********************************************************************
	 */
	public Integer add(Job object) {
		Session session = HibernateSessionUtil.getSession();
		Integer id = (Integer) session.save(object);
		if (id > 0)
			return id;
		return 0;

	}

	/***********************************************************************
	 * Find Job By id
	 * **********************************************************************
	 */
	public Job findJob(Integer jobId) {
		Session session = HibernateSessionUtil.getSession();
		Job jobModel = (Job) session.get(Job.class, jobId);
		return jobModel;
	}

	/***********************************************************************
	 * Get all job list from Job Table
	 * **********************************************************************
	 */
	public List<Job> fetchAllJob() {
		Session session = HibernateSessionUtil.getSession();
		@SuppressWarnings("unchecked")
		List<Job> list = session.createQuery("from com.hm.app.model.Job where t_active = true").list();
		return list;
	}

	

	/***********************************************************************
	 * Get Individual Posted Job
	 * **********************************************************************
	 * 
	 */

	@SuppressWarnings("deprecation")
	public List<Job> getPostedJob(Integer userId) {
		Session session = HibernateSessionUtil.getSession();
		Query query = session
				.createQuery("from com.hm.app.model.Job where posted_by=:userId and t_active=true");
		query.setParameter("userId", userId);
		List<Job> list = query.list();
		return list;
	}

	/***********************************************************************
	 * Verify Job for User
	 * **********************************************************************
	 */

	public Integer getPostedJob(Integer userId, Integer jobId) {
		Session session = HibernateSessionUtil.getSession();
		Query query = session
				.createQuery("from com.hm.app.model.Job where posted_by=:userId and jobId=:jobId");
		query.setParameter("userId", userId);
		query.setParameter("jobId", jobId);
		Integer job = query.getResultList().size();
		return job;
	}

	
	/***********************************************************************
	 * Delete Job
	 * **********************************************************************
	 * 
	 */

	public boolean delete(Job object) {
		Session session = HibernateSessionUtil.getSession();
		session.saveOrUpdate(object);
		return true;
	}

	/***********************************************************************
	 * Delete all posted job
	 * **********************************************************************
	 * 
	 */
	public List<Integer> deactivateAllUserPostejob(Integer id) {
		Session session = HibernateSessionUtil.getSession();
		Query query = session
				.createQuery("from com.hm.app.model.Job where posted_by=:id and t_active=true");
		query.setParameter("id", id);
		List<Job> job = query.list();
		List<Integer> jobIds = new ArrayList<>();
		job.stream().forEach(x -> {
			x.setTemporaryActive("false");
			jobIds.add(x.getId());
			session.saveOrUpdate(x);
		});
		return jobIds;
	}

	/***********************************************************************
	 * Get all applied from application(For Sitter)
	 * **********************************************************************
	 * 
	 */
	public List<Job> getAppliedJob(int applyBy) {
		Session session = HibernateSessionUtil.getSession();
		Query query = session.createQuery("from com.hm.app.model.Application where apply_by=:applyBy");
		query.setParameter("applyBy", applyBy);
		List<Application> appliedJobs = query.list();
		List<Job> jobList = new ArrayList<>();
		appliedJobs.stream().forEach(x -> jobList.add(x.getJobId()));
		return jobList;
	}

	
	/***********************************************************************
	 * Application Deactivate
	 * **********************************************************************
	 */
	public void applicationDeactivate(List<Integer> jobIds) {
		Session session = HibernateSessionUtil.getSession();
		Query query = session.createQuery("from com.hm.app.model.Application where job_id IN (:jobIds)");
		query.setParameter("jobIds", jobIds);
		List<Application> app = query.getResultList();
		app.stream().forEach(x -> {
			x.setTemporaryActive("false");
			session.saveOrUpdate(x);
		});
	}

	/***********************************************************************
	 * Get applicants for job
	 * **********************************************************************
	 */
	public List<Application> getNoOfApplicantforJob(Integer jobId) {
		Session session = HibernateSessionUtil.getSession();
		Query query = session.createQuery("from com.hm.app.model.Application where job_id=:jobId");
		query.setParameter("jobId", jobId);
		List<Application> list = query.getResultList();
		return list;
	}
}
