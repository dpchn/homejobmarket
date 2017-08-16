package com.hm.app.model;

public class Application {
	private int id;
	private Job jobId;
	private User applyBy;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Job getJobId() {
		return jobId;
	}
	public void setJobId(Job jobId) {
		this.jobId = jobId;
	}
	public User getApplyBy() {
		return applyBy;
	}
	public void setApplyBy(User applyBy) {
		this.applyBy = applyBy;
	}
	


}
