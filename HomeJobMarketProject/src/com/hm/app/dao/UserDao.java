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
		if (id > 0)
			return id;
		return 0;

	}

	/**********
	 * Application***********************************************************************
	 * Check User Exist or Not
	 *********************************************************************************
	 */
	public boolean isExist(String email) {
		Session session = HibernateSessionUtil.getSession();
		org.hibernate.Query query = session.createQuery("from com.hm.app.model.User where email = :email");
		query.setParameter("email", email);
		return query.uniqueResult() != null;
	}

	/*********************************************************************************
	 * Is user account Active ?
	 *********************************************************************************
	 */
	public String isActive(String email) {
		Session session = HibernateSessionUtil.getSession();
		org.hibernate.Query query = session.createQuery("from com.hm.app.model.User where email =:email");
		query.setParameter("email", email);
		User u = (User) query.uniqueResult();
		return u.getTemporaryActive();
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
				.createQuery("from com.hm.app.model.User where email=:email and password=:password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		User user = (User) query.uniqueResult();
		if (user != null)
			return user;
		return null;
	}

	/*
	 * User Update
	 */
	public boolean update(User obj, int id) {
		Session session = HibernateSessionUtil.getSession();
		User user = session.load(User.class, id);
		/*System.out.println("Valu in Update Dao "+ user);*/
		/*session.update(obj);
		session.flush();*/
		session.merge(obj);
		return true;
	}

	/*
	 * static void test() { Session session =
	 * CreateSession.sessionFactory.openSession(); org.hibernate.Query q =
	 * session.createQuery("from com.hm.app.model.User"); List<User> list =
	 * q.getResultList(); List<Application> l = new ArrayList<Application>();
	 * //list.stream().forEach(x->System.out.println(x.getApplications()));
	 * list.stream().forEach(x->{ Set<Job> a = x.getJobs();
	 * System.out.println(x.getfName()); for(Job j: a)
	 * System.out.println(j.getId()); }); }
	 * 
	 * public static void main(String[] args) { test(); }
	 */

}