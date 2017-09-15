package com.hm.app.framework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hm.app.util.MyInterceptor;

public class HibernateSessionUtil {

	public static ThreadLocal<Session> threadLocalSession = new ThreadLocal<Session>();
	public static SessionFactory sessionFactory;
	static {
		sessionFactory = new Configuration().configure("com/hm/app/framework/hibernate.cfg.xml").buildSessionFactory();
	}

	
	public static Session getSession() {
		Session session = threadLocalSession.get();
		if (session == null) {
			session = sessionFactory.withOptions().interceptor(new MyInterceptor()).openSession();
			threadLocalSession.set(session);
		}
		return session;
	}

	public static void destroySession() {
		threadLocalSession.remove();
	}
	


}
