package com.hm.app.model;

public class Application  implements TrackActivity{
	private int id;
	private Job jobId;
	private User applyBy;
	private String temporaryActive;

	@Override
	public boolean equals(Object obj) {
		
		return obj instanceof Application && ((User)obj).getId() == getId();
	}
	
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

	@Override
	public int getUserId() {
		User u = new User();
		return u.getId();
	}

	@Override
	public String getModelType() {
		// TODO Auto-generated method stub
		return "Application";
	}

}
