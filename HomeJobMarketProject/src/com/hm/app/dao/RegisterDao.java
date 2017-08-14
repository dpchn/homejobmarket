package com.hm.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hm.app.model.RegisterModel;
import com.hm.app.util.CreateSession;

public class RegisterDao {
	public static int add(RegisterModel object) {
		System.out.println("Member id:"+object.getId());
		Session session = CreateSession.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("Dao...");
		
		
		try {
			Integer id = (Integer)(session.save(object));
			System.out.println("Return of session save :"+session.save(object));
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
	
	public static RegisterModel findId(Integer id){
		Session session= CreateSession.sessionFactory.openSession();
		RegisterModel registerModel = (RegisterModel)session.get(RegisterModel.class, id);
	return registerModel;
	}
	
	

}