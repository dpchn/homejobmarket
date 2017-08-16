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
		System.out.println("Dao...");

		try {
			Integer id = (Integer) (session.save(object));
			System.out.println("Return of session save :" + session.save(object));
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
	public Map<String, Object> loginUser(String email, String password) {
		System.out.println("Inside login dao...");
		Session session = CreateSession.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			User userModel = (User) session.createQuery(
					"from com.hm.app.model.User where email='" + email + "' and password='" + password + "'")
					.uniqueResult();
			Map<String, Object> details = new HashMap<String, Object>();
			details.put("fName", userModel.getfName().toString());
			details.put("lName", userModel.getlName().toString());
			details.put("phone", userModel.getphoneNo().toString());
			details.put("email", userModel.getEmail().toString());
			details.put("noOfChild", userModel.getNoOfChild());
			details.put("id", userModel.getId());
			System.out.println("Hello.." + details.size());		
			details.put("type", userModel.getType().toString());

			transaction.commit();
			session.close();

			return details;
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
			System.out.println("updated.....");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			System.out.println("Error ");
			return false;
		}
		
	}

}