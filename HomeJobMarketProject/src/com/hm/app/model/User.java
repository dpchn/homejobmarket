package com.hm.app.model;

import java.util.Set;

public class User implements TrackActivity {

	@Override
	public boolean equals(Object obj) {
		
		return obj instanceof User && ((User)obj).getId() == getId();
	}

	private int id;
	private String fName;
	private String lName;
	private String phoneNo;
	private String email;
	private String password;
	private int noOfChild;
	private Set<Job> jobs;
	private Set<Application> applications;
	

	private String temporaryActive;
	// private enum type {seeker,sitter};
	
	
	public Set<Job> getJobs() {
		return jobs;
	}

	public Set<Application> getApplications() {
		return applications;
	}

	public void setApplications(Set<Application> applications) {
		this.applications = applications;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getTemporaryActive() {
		return temporaryActive;
	}

	public void setTemporaryActive(String temporaryActive) {
		this.temporaryActive = temporaryActive;
	}

	private String type;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNoOfChild() {
		return noOfChild;
	}

	public void setNoOfChild(int noChild) {
		this.noOfChild = noChild;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getphoneNo() {
		return phoneNo;
	}

	public void setphoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int getUserId() {
		return id;
	}

	@Override
	public String getModelType() {
		return "User";
	}
}