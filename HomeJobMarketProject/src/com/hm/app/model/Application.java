package com.hm.app.model;

import com.hm.app.framework.Status;

public class Application  implements TrackActivity{
	private int id;
	private Job job;
	private User applyBy;
	private Status status;

	@Override
	public boolean equals(Object obj) {
		
		return obj instanceof Application && ((User)obj).getId() == getId();
	}
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Job getJobId() {
		return job;
	}

	public void setJobId(Job jobId) {
		this.job = jobId;
	}

	public User getApplyBy() {
		return applyBy;
	}

	public void setApplyBy(User applyBy) {
		this.applyBy = applyBy;
	}

	@Override
	public int getUserId() {
		return getApplyBy().getId();
	}

	@Override
	public String getModelType() {
		return "Application";
	}
}
