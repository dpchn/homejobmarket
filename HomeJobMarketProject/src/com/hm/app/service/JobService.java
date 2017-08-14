package com.hm.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.*;
import java.util.Date;

import com.hm.app.dao.JobDao;
import com.hm.app.model.JobModel;

public class JobService {
	public static Integer createJob(Integer id,String jobTitle, String jobDes, String startDate, String endDate, String startTime,
			String endTime, float payPerHour) {
		SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
		SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
		
		
		
		System.out.println("stardate :"+startDate);
		System.out.println("enddate :"+endDate);
		Date d1=null, d2=null;
		try {
			d1 = startDateFormat.parse(startDate + " " + startTime);
			d2 = endDateFormat.parse(endDate + " " + startTime);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		
		JobModel jobModel = new JobModel();
		jobModel.setPostedBy(id);
		jobModel.setJobDes(jobDes);
		jobModel.setStartDate(d1);
		jobModel.setEndDate(d2);
		jobModel.setPayPerHour(payPerHour);
		return JobDao.add(jobModel);
	}
}
