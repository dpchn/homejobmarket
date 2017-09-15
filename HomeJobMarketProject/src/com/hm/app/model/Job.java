package com.hm.app.model;

import java.util.Date;
import java.util.Set;

public class Job  implements TrackActivity{
	private int id;
	private String jobTitle;
	private String jobDes;
	private Date startDate;
	private Date endDate;
	private User postedBy;
	private String temporaryActive;
	private Set<Application> applications;
	
	@Override
	public boolean equals(Object obj) {
		
		return obj instanceof Job && ((User)obj).getId() == getId();
	}
	
	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}

	public String getTemporaryActive() {
		return temporaryActive;
	}

	public void setTemporaryActive(String temporaryActive) {
		this.temporaryActive = temporaryActive;
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

	@Override
	public int getUserId() {
		User u = new User();
		return u.getId();
	}

	@Override
	public String getModelType() {
		// TODO Auto-generated method stub
		return "Job";
	}

	

}
