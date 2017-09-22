package com.hm.app.service;


import java.util.*;

import com.hm.app.dao.*;
import com.hm.app.framework.LogHibernateModel;
import com.hm.app.model.LogHistory;
public class LogService implements LogHibernateModel{
	LogDao logdao = new LogDao();
	UserDao userDao =  new UserDao();
	
	public void saveHistory(int userId, String operation, int modelId, String modelType) {
		LogHistory history = new LogHistory();
		history.setUserId(userId);
		history.setOperation(operation);
		history.setOperation(operation);
		history.setModelId(modelId);
		history.setModelType(modelType);
		logdao.saveLog(history);
	}
	
	
	public List<Object> RecentActivity(int id){
		List<Object> list = new ArrayList<Object>();
		Map<Object, Object> map = new HashMap<Object, Object>();
		for(LogHistory lh : logdao.getHistory(id)) {
			list.add(lh.getOperation());
			
		}
		return list;
	}

}
