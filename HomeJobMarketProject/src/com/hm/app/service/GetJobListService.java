package com.hm.app.service;

import java.util.Map;

import com.hm.app.dao.GetJobListDao;

public class GetJobListService {
	
	public static Map getAllJob() {
		return GetJobListDao.fetchAllJob();
	}

}
