package com.hm.app.dao;

import org.hibernate.*;
import com.hm.app.framework.HibernateSessionUtil;
import com.hm.app.model.User;

public class UserDao {

	/*
	 * Add new User
	 */
	public int add(User object) {
		Session session = HibernateSessionUtil.getSession();
		Integer id = (Integer) (session.save(object));
		return id;

	}

	/**********
	 * Application***********************************************************************
	 * Check User Exist or Not
	 *********************************************************************************
	 */
	public boolean isExist(String email) {
		Session session = HibernateSessionUtil.getSession();
		org.hibernate.Query query = session.createQuery("from com.hm.app.model.User where EMAIL = :email");
		query.setParameter("email", email);
		return query.uniqueResult() != null;
	}

	/*********************************************************************************
	 * Is user account Active ?
	 *********************************************************************************
	 */
	public String isActive(String email) {
		Session session = HibernateSessionUtil.getSession();
		org.hibernate.Query query = session.createQuery("from com.hm.app.model.User where EMAIL =:email");
		query.setParameter("email", email);
		User u = (User) query.uniqueResult();
		return u.getStatus().toString();
	}

	/***************************************************************
	 * Find User By id
	 * **************************************************************
	 */

	public User findId(Integer id) {
		Session session = HibernateSessionUtil.sessionFactory.openSession();
		User user = (User) session.get(User.class, id);
		session.close();
		return user;
	}

	/*
	 * Login User
	 */
	public User loginUser(String email, String password) {
		Session session = HibernateSessionUtil.getSession();
		org.hibernate.Query query = session
				.createQuery("from com.hm.app.model.User where EMAIL=:email and PASSWORD=:password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		User user = (User) query.uniqueResult();
		return user;
	}

	
	/*
	 * User Update
	 */
	public boolean update(User obj, int id) {
		Session session = HibernateSessionUtil.getSession();
		session.merge(obj);
		return true;
	}


}