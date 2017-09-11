package com.hm.app.model;

public class Application {
	private int id;
	private Job jobId;
	private User applyBy;
	private String temporaryActive;

	public String getTemporaryActive() {
		return temporaryActive;
	}

	public void setTemporaryActive(String temporaryActive) {
		this.temporaryActive = temporaryActive;
	}

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
