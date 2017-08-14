package com.hm.app.util;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class CreateSession {
	public static SessionFactory  sessionFactory;
	static {
		sessionFactory = new Configuration().configure("com/hm/app/framework/hibernate.cfg.xml").buildSessionFactory();
	}

	
}
