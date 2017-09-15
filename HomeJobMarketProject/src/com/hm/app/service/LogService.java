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
		//logdao.getHistory(id);
		List<Object> list = new ArrayList<Object>();
		Map<Object, Object> map = new HashMap<Object, Object>();
		for(LogHistory lh : logdao.getHistory(id)) {
			/*map.put("operation", lh.getOperation());
			map.put("model", lh.getModelType());*/
			list.add(lh.getOperation());
			
		}
		return list;
	}
	/*public static void main(String[] args) {
		LogDao dao = new LogDao();
		for(LogHistory l: dao.getHistory(39))
			System.out.println();
	}
	*/

}
