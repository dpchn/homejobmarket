package com.hm.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.*;
import java.util.ArrayList;
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
	UserDao userDao = new UserDao();
	ApplicationDao applicationDao = new ApplicationDao();
	Application application = new Application();

	/**************************************************************************************
	 * Create Job
	 **************************************************************************************
	 */
	public Integer createJob(Integer id, String jobTitle, String jobDes, String startDate, String endDate,
			String startTime, String endTime, float payPerHour) {

		SimpleDateFormat startDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm");
		SimpleDateFormat endDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm");
		Date d1 = null, d2 = null;
		try {
			d1 = startDateFormat.parse(startDate + " " + startTime);
			d2 = endDateFormat.parse(endDate + " " + startTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Job jobModel = new Job();
		jobModel.setPostedBy(new UserDao().findId(id));
		jobModel.setJobTitle(jobTitle);
		jobModel.setJobDes(jobDes);
		jobModel.setStartDate(d1);
		jobModel.setEndDate(d2);
		jobModel.setTemporaryActive("true");
		jobModel.setPayPerHour(payPerHour);
		return jobDao.add(jobModel);
	}

	/**************************************************************************************
	 * Get Job list
	 **************************************************************************************
	 */

	public List<Object> getAllJob(Integer memberId) {
		ApplicationDao applicationDao = new ApplicationDao();
		List<Job> job = jobDao.fetchAllJob();
		List<Integer> jobIds = new ArrayList<>();
		job.stream().forEach(x -> jobIds.add(x.getId()));

		List<Integer> jobs = applicationDao.getAppliedJob(memberId);
		List<Object> jobList = new ArrayList<>();
		for (Job l : job) {
			if (!jobs.contains(l.getId())) {
				Map<String, Object> obj = new HashMap<>();
				obj.put("jobId", l.getId());
				obj.put("jobTitle", l.getJobTitle());
				obj.put("jobDes", l.getJobDes());
				obj.put("startDate", l.getStartDate());
				obj.put("endDate", l.getEndDate());
				obj.put("payPerHour", l.getPayPerHour());
				obj.put("postedBy", l.getPostedBy().getfName());
				jobList.add(obj);
			}
		}
		return jobList;
	}

	/*************************************************************************************
	 * Apply Job
	 *************************************************************************************
	 */
	public Integer applyJob(Integer jobId, Integer memberId) {
		application.setJobId(jobDao.findJob(jobId));
		application.setApplyBy(userDao.findId(memberId));
		application.setTemporaryActive("true");
		return applicationDao.apply(application);
	}

	/********************************************************************************************
	 * Get Individual Posted Job
	 * *******************************************************************************************
	 */
	public List<Object> getMyPostedJob(Integer id) {
		List<Job> job = jobDao.getPostedJob(id);
		List<Object> jobList = new ArrayList<>();
		for (Job l : job) {
			Map<String, Object> obj = new HashMap<>();
			System.out.println(l.getId());
			obj.put("jobId", l.getId());
			obj.put("jobTitle", l.getJobTitle());
			obj.put("jobDes", l.getJobDes());
			obj.put("startDate", l.getStartDate());
			obj.put("endDate", l.getEndDate());
			obj.put("payPerHour", l.getPayPerHour());
			jobList.add(obj);
		}
		return jobList;
	}

	/*
	 * Delete Job
	 */
	public boolean deleteJob(Integer jobId) {
		Job job = jobDao.findJob(jobId);
		job.setTemporaryActive("false");
		job.getApplications().stream().forEach(x->x.setTemporaryActive("false"));
		return jobDao.delete(job);
	}

	/*
	 * Get applied job list(For Sitter)
	 */

	public Map<Object, Object> getAppliedJob(int applyBy) {
		Map<Object, Object> joblist = new HashMap<>();
		jobDao.getAppliedJob(applyBy).stream().forEach(x -> {
			Map<String, Object> obj = new HashMap<>();
			obj.put("JobTitle", x.getJobTitle());
			obj.put("JobDes", x.getJobDes());
			obj.put("StartDate", x.getStartDate());
			obj.put("EndDate", x.getEndDate());
			joblist.put(x.getId(), obj);
		});
		return joblist;
	}

	
	
	
	/*
	 * Check Job Exist
	 */
	public boolean isJobExist(int jobId){
		return jobDao.findJob(jobId)!=null;
	}
	

	
	
	
	/*
	 * Verify Job belong to User 
	 */
	
	public boolean verifyJob(int userId, int jobId){
		return jobDao.getPostedJob(userId, jobId) != 0;
	}
	
	
	
}
