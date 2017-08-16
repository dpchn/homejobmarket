package com.hm.app.model;

import java.util.Date;

public class Job {
	private int id;
	private String jobTitle;
	private String jobDes;
	private Date startDate;
	private Date endDate;
	private User postedBy;
	
	public Job() {
		
	}
	
	public Job(String jobTitle, String jobDes, Date startDate, Date endDate, User postedBy) {
		this.jobTitle = jobTitle;
		this.jobDes = jobDes;
		this.startDate = startDate;
		this.endDate = endDate;
		this.postedBy = postedBy;
		
	}

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	private float payPerHour;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDes() {
		return jobDes;
	}

	public void setJobDes(String jobDes) {
		this.jobDes = jobDes;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	

	public float getPayPerHour() {
		return payPerHour;
	}

	public void setPayPerHour(float payPerHour) {
		this.payPerHour = payPerHour;
	}

	

}
