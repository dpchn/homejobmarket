package com.hm.app.dao;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hm.app.model.JobModel;
import com.hm.app.util.CreateSession;

public class JobDao {
	public static Integer add(JobModel object) {
		Session session = CreateSession.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("Job Dao...");

		try {
			Integer id = (Integer)session.save(object);
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

}
