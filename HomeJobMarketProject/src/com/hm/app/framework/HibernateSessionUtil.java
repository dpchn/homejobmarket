package com.hm.app.framework;

import org.hibernate.Session;

import com.hm.app.util.CreateSession;

public class HibernateSessionUtil {

	public static ThreadLocal<Session> threadLocalSession = new ThreadLocal<Session>();

	public static Session getSession() {
		Session session = threadLocalSession.get();
		if (session == null) {
			session = CreateSession.sessionFactory.openSession();
			threadLocalSession.set(session);
		}
		return session;
	}

	public static void destroySession() {
		threadLocalSession.remove();
	}
}
