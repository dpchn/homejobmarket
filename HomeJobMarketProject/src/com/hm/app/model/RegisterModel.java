package com.hm.app.model;

public class RegisterModel {

	private int id;
	private String fName;
	private String lName;
	private String phoneNo;
	private String email;
	private String password;
	private int noOfChild;
	// private enum type {seeker,sitter};
	
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
}