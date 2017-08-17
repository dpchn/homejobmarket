package com.hm.app.dao;

import java.util.*;
import java.util.Map;

import org.hibernate.*;

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
			e.printStackTrace();
			transaction.rollback();
			session.close();
			return 0;
		}
	}

	/*
	 * Find User By id
	 */

	public User findId(Integer id) {
		Session session = CreateSession.sessionFactory.openSession();
		User registerModel = (User) session.get(User.class, id);
		session.close();
		return registerModel;
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

}