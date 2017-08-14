package com.hm.app.dao;



import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.query.*;

import com.hm.app.model.RegisterModel;
import com.hm.app.util.CreateSession;

public class UpdateDao {

	public static boolean update(RegisterModel obj) {
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
