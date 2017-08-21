package com.hm.app.dao;

import java.util.*;

import org.hibernate.*;

import com.hm.app.model.Application;
import com.hm.app.model.Job;
import com.hm.app.model.User;
import com.hm.app.util.CreateSession;

public class UserDao {

	/*
	 * Add new User
	 */
	public int add(User object) {
		System.out.println("Member id:" + object.getId());
		Session session = CreateSession.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Integer id = (Integer) (session.save(object));
			transaction.commit();
			session.close();
			return id;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			session.close();
			return 0;
		}
	}

	/**********Application***********************************************************************
	 * Check User Exist or Not
	 *********************************************************************************
	 */
		public boolean isExist(String email) {
			Session session = CreateSession.sessionFactory.openSession();
			org.hibernate.Query query = session.createQuery("from com.hm.app.model.User where email = :email");
			query.setParameter("email", email);
			System.out.println(query.uniqueResult());
			return query.uniqueResult()!=null;
		}
	
		
		/*********************************************************************************
		 * Is user account Active ?
		 *********************************************************************************
		 */
		public String isActive(String email) {
			Session session = CreateSession.sessionFactory.openSession();
			org.hibernate.Query query = session.createQuery("from com.hm.app.model.User where email =:email");
			query.setParameter("email", email);
			User u = (User)query.uniqueResult();
			System.out.println("active is "+u.getTemporaryActive());
			return u.getTemporaryActive();		
		}
	
		
		
	/***************************************************************
	 * Find User By id
	 * **************************************************************
	 */
		
	public User findId(Integer id) {
		Session session = CreateSession.sessionFactory.openSession();
		User user = (User) session.get(User.class, id);
		session.close();
		return user;
	}
	
	

	/*
	 * Login User
	 */
	public User loginUser(String email, String password) {
		System.out.println("Inside login dao...");
		Session session = CreateSession.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			User user = (User) session.createQuery(
					"from com.hm.app.model.User where email='" + email + "' and password='" + password + "'")
					.uniqueResult();
			transaction.commit();
			session.close();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			session.close();
			return null;
		}
	}
	
	
	
	
	/*
	 * Update
	 */
	public boolean update(User obj) {
		System.out.println("Inside UpdateDao....");
		Session session = CreateSession.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(obj);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			System.out.println("Error ");
			return false;
		}
	}
	
	
	static void test() {
		Session session = CreateSession.sessionFactory.openSession();
		org.hibernate.Query q = session.createQuery("from com.hm.app.model.User");
		List<User> list = q.getResultList();
		List<Application> l = new ArrayList<Application>();
		//list.stream().forEach(x->System.out.println(x.getApplications()));
		list.stream().forEach(x->{
			Set<Job> a = x.getJobs();
			System.out.println(x.getfName());
			for(Job j: a)
				System.out.println(j.getId());
		});
	}
	
	public static void main(String[] args) {
		test();
	}

}