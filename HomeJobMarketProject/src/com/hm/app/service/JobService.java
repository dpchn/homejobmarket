package com.hm.app.service;

import java.text.ParseException;
import java.util.*;
import com.hm.app.dao.*;
import com.hm.app.framework.Status;
import com.hm.app.model.*;
import com.hm.app.util.ConstantPattern;

public class JobService {
	JobDao jobDao = new JobDao();
	Job jobModel = new Job();
	User  user = new User();
	UserDao userDao = new UserDao();
	ApplicationDao applicationDao = new ApplicationDao();
	Application application = new Application();

	
	/**************************************************************************************
	 * Create Job
	 **************************************************************************************
	 */
	public Integer createJob(Integer id, String jobTitle, String jobDes, String startDate, String endDate,
			String startTime, String endTime, float payPerHour) {

		Date d1 = null, d2 = null;
		try {
			d1 = ConstantPattern.sdf.parse(startDate + " " + startTime);
			d2 = ConstantPattern.sdf.parse(endDate + " " + startTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Job jobModel = new Job();
		jobModel.setPostedBy(userDao.findId(id));
		jobModel.setJobTitle(jobTitle);
		jobModel.setJobDes(jobDes);
		jobModel.setStartDate(d1);
		jobModel.setEndDate(d2);
		jobModel.setStatus(Status.ACTIVE);;
		jobModel.setPayPerHour(payPerHour);
		return jobDao.add(jobModel);
	}

	/**************************************************************************************
	 * Get Job list
	 **************************************************************************************
	 */

	public List<Object> getAllJob(Integer memberId) {
		List<Integer> appliedJobs = applicationDao.getAppliedJob(memberId);
		List<Job> job = jobDao.fetchAllJob();
		List<Object> jobList = new ArrayList<>();
		for (Job l : job) {
			if (!appliedJobs.contains(l.getId())) {
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
		application.setStatus(Status.ACTIVE);
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

	/*******************************************************************
	 * Delete Job
	 ********************************************************************
	 */
	public boolean deleteJob(Integer jobId) {
		Job job = jobDao.findJob(jobId);
		job.setStatus(Status.INACTIVE);
		job.getApplications().stream().forEach(x -> x.setStatus(Status.INACTIVE));
		return jobDao.delete(job);
	}

	/*
	 * GetJob For Update
	 */
	public Map getJob(Integer jobId) {
		Job job = jobDao.findJob(jobId);
		Map<String, Object> map = new HashMap();
		map.put("jobTitle", job.getJobTitle());
		map.put("jobDes", job.getJobDes());
		map.put("startDate", job.getStartDate().getDate());
		map.put("endDate", job.getEndDate().getDate());
		map.put("startTime", job.getStartDate().getTime());
		map.put("endTime", job.getEndDate().getTime());
		map.put("payPerHour", job.getPayPerHour());
		return map;
	}
	/********************************************************************
	 * Get applied job list(For Sitter)
	 * *******************************************************************
	 */

	public Map<Object, Object> getAppliedJob(int applyBy) {
		Map<Object, Object> joblist = new HashMap<>();
		jobDao.getAppliedJob(applyBy).stream().forEach(x -> {
			Map<String, Object> obj = new HashMap<>();
			obj.put("JobTitle", x.getJobTitle());
			obj.put("JobDes", x.getJobDes());
			obj.put("StartDate", x.getStartDate());
			obj.put("EndDate", x.getEndDate());
			obj.put("status", x.getStatus());
			joblist.put(x.getId(), obj);
		});
		return joblist;
	}

	
	/********************************************************************
	 * Check Job Exist
	 * *******************************************************************
	 */
	public boolean isJobExist(int jobId) {
		return jobDao.findJob(jobId) != null;
	}

	/********************************************************************
	 * Verify Job belong to User
	 * *******************************************************************
	 */

	public boolean verifyJob(int userId, int jobId) {
		return jobDao.getPostedJob(userId, jobId) != 0;
	}

}
