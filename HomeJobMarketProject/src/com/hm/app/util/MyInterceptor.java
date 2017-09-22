package com.hm.app.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.hibernate.type.Type;
import com.hm.app.model.*;
import com.hm.app.service.LogService;

public class MyInterceptor implements Interceptor {
	LogService logService = new LogService();

	List<Object> objects = new ArrayList<>();

	@Override
	public void afterTransactionBegin(Transaction transaction) {

		// System.out.println("afterTransactionBegin....");
	}

	@Override
	public void afterTransactionCompletion(Transaction transaction) {
		// System.out.println("afterTransactionCompletion...."+transaction.getClass());

	}

	@Override
	public void beforeTransactionCompletion(Transaction transaction) {
		// System.out.println("beforeTransactionCompletion.....");

	}

	@Override
	public int[] findDirty(Object object, Serializable serializable, Object[] newValue, Object[] oldValue,
			String[] strings, Type[] types) {
		// System.out.println("findDirty...." + object.getClass().getName());

		return null;
	}

	@Override
	public Object getEntity(String string, Serializable serializable) throws CallbackException {
		// System.out.println("getEntity....");
		return null;
	}

	@Override
	public String getEntityName(Object object) throws CallbackException {
		return null;
	}

	@Override
	public Object instantiate(String string, EntityMode entityMode, Serializable serializable)
			throws CallbackException {
		// System.out.println("instantiate....");
		return null;
	}

	@Override
	public Boolean isTransient(Object object) {
		// System.out.println("isTransient..........."+object);
		return null;
	}

	@Override
	public void onCollectionRecreate(Object object, Serializable serializable) throws CallbackException {
		// System.out.println("onCollectionRecreate..........."+
		// object.getClass().getName());

	}

	@Override
	public void onCollectionRemove(Object object, Serializable serializable) throws CallbackException {
		// System.out.println("onCollectionRemove......."+ object.getClass().getName());

	}

	@Override
	public void onCollectionUpdate(Object object, Serializable serializable) throws CallbackException {
		// System.out.println("onCollectionUpdate......."+ object.getClass().getName());

	}

	@Override
	public void onDelete(Object object, Serializable serializable, Object[] arg2, String[] arg3, Type[] arg4)
			throws CallbackException {
		// System.out.println("onDelete......."+object.getClass().getName());

	}

	@Override
	public boolean onFlushDirty(Object object, Serializable arg1, Object[] newValue, Object[] oldValue, String[] arg4,
			Type[] arg5) throws CallbackException {
		System.out.println("onFlushDirty......." + object.getClass().getName());
		TrackActivity activity = (TrackActivity) object;
		if (oldValue != null && !objects.contains(object)){
			logService.saveHistory(activity.getUserId(), " Profile Update", activity.getId(), activity.getModelType());
		}
		return false;
	}

	@Override
	public boolean onLoad(Object object, Serializable arg1, Object[] arg2, String[] arg3, Type[] arg4)
			throws CallbackException {
		return false;
	}

	@Override
	public String onPrepareStatement(String arg0) {
		// System.out.println("onPrepareStatement......."+arg0);
		return null;
	}

	@Override
	public boolean onSave(Object object, Serializable id, Object[] newValue, String[] oldValue, Type[] arg4)
			throws CallbackException {
		System.out.println("onSave.........." + object.getClass().getName());

		if (object instanceof TrackActivity && !objects.contains(object)) {
			TrackActivity activity = (TrackActivity) object;
			logService.saveHistory(activity.getUserId(), activity.getModelType() + " Created", activity.getId(),
					activity.getModelType());
			objects.add(object);
		}
		return false;
	}

	

	@Override
	public void postFlush(Iterator iterator) throws CallbackException {
		// System.out.println("postFlush..........."+ iterator);

	}

	@Override
	public void preFlush(Iterator arg0) throws CallbackException {
		// System.out.println("preflush.......");

	}

}
