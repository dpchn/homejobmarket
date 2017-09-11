package com.hm.app.util;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import com.hm.app.dao.*;


public class MyInterceptor extends EmptyInterceptor{

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("Save action");
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
	public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("Delete Action...");
		super.onDelete(entity, id, state, propertyNames, types);
	}
	
	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
	/*	System.out.println("Update Action....");
		return true;*/
		if(entity instanceof UserDao) {
			System.out.println("User Dao Access");
			return true;
		}
		if(entity instanceof ApplicationDao) {
			System.out.println("Application Dao access");
			return true;
		}
		if(entity instanceof JobDao) {
			System.out.println("Job Dao access");
			return true;
		}
		return false;
	}
}
