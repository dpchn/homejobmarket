package com.hm.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.*;
import java.util.Date;
import java.util.Map;

import com.hm.app.dao.ApplicationDao;
import com.hm.app.dao.JobDao;
import com.hm.app.dao.UserDao;
import com.hm.app.model.Application;
import com.hm.app.model.Job;
import com.hm.app.model.User;

public class JobService {
	JobDao jobDao = new JobDao();
	Job jobModel = new Job();
	UserDao userDao =new UserDao();
	ApplicationDao applicationDao= new ApplicationDao();
	Application application = new Application();

	/*
	 * Create Job
	 */
	public Integer createJob(Integer id, String jobTitle, String jobDes, String startDate, String endDate,
			String startTime, String endTime, float payPerHour) {

		SimpleDateFormat startDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
		SimpleDateFormat endDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");

		System.out.println("stardtime :" + startTime);
		System.out.println("endtime :" + endTime);
		System.out.println("stardate :" + startDate);
		System.out.println("enddate :" + endDate);
		System.out.println("stardate :" + startDateFormat);
		System.out.println("enddate :" + endDateFormat);
		Date d1 = null, d2 = null;
		try {
			d1 = startDateFormat.parse(startDate + " " + startTime);
			d2 = endDateFormat.parse(endDate + " " + startTime);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		Job jobModel = new Job();
		// System.out.println("fName :"+ new RegisterModel().getfName());
		jobModel.setPostedBy(new UserDao().findId(id));
		jobModel.setJobTitle(jobTitle);
		jobModel.setJobDes(jobDes);
		jobModel.setStartDate(d1);
		jobModel.setEndDate(d2);
		jobModel.setPayPerHour(payPerHour);
		return jobDao.add(jobModel);
	}

	/*
	 * Get Job list
	 */

	public Map getAllJob(Integer memberId) {
		ApplicationDao applicationDao = new ApplicationDao();
		return jobDao.fetchAllJob(applicationDao.getAppliedJob(memberId));
	}

	/*
	 * Apply Job
	 */

	public Integer applyJob(Integer jobId, Integer memberId) {

		System.out.println("Member id : " + memberId);
		application.setApplyBy(userDao.findId(memberId));
		application.setJobId(jobDao.findJob(jobId));

		return applicationDao.apply(application);
	}

}
