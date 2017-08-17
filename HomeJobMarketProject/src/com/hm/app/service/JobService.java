package com.hm.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

		SimpleDateFormat startDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm");
		SimpleDateFormat endDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm");

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
		List<Job> job =  jobDao.fetchAllJob();
		List<Integer> jobIds = applicationDao.getAppliedJob(memberId);
		Map<Object, Object> joblist = new HashMap<>();
		for (Job l : job) {
			if (!jobIds.contains(l.getId())) {
				Map<String, Object> obj = new HashMap<>();
				obj.put("jobId", l.getId());
				obj.put("jobTitle", l.getJobTitle());
				obj.put("jobDes", l.getJobDes());
				obj.put("startDate", l.getStartDate());
				obj.put("endDate", l.getEndDate());
				obj.put("payPerHour", l.getPayPerHour());
				obj.put("postedBy", l.getPostedBy());
				joblist.put(l.getId(), obj);
			}
		}
		
		return joblist;
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
