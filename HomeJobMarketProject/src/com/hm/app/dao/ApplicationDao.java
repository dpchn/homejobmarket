package com.hm.app.dao;

import java.util.*;
import org.hibernate.Session;
import com.hm.app.framework.HibernateSessionUtil;
import com.hm.app.model.Application;

public class ApplicationDao {

	/****************************************
	 *Apply to Job 
	 *************************************
	 */
	public Integer apply(Application model) {
		Session session = HibernateSessionUtil.getSession();
		Integer appId = (Integer) session.save(model);
		return appId;
	}

	/******************************************
	 * 
	 * Get Applied Job list ****************************************
	 */
	public List<Integer> getAppliedJob(Integer memberId) {
		Session session = HibernateSessionUtil.getSession();
		org.hibernate.Query query = session.createQuery("from com.hm.app.model.Application where APPLY_BY =:id");
		query.setParameter("id", memberId);

		List<Application> app = query.getResultList();
		List<Integer> jobList = new ArrayList<>();
		app.stream().forEach(x -> jobList.add(x.getJobId().getId()));
		return jobList;
	}

}
