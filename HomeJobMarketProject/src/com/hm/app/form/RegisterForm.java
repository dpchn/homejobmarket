package com.hm.app.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import org.apache.struts.validator.ValidatorForm;

import com.hm.app.util.ConstantPattern;

public class RegisterForm extends ValidatorForm {


	
	private int id;
	private String fName;
	private String lName;
	private String phoneNo;
	private String email;
	private String password;
	private int noChild;
	// private enum type {seeker,sitter};
	private String type;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNoChild() {
		return noChild;
	}

	public void setNoChild(int noChild) {
		this.noChild = noChild;
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
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		System.out.println("Inside Form .......");
		ActionErrors actionErrors = new ActionErrors();
		ConstantPattern cp = new ConstantPattern();
		
		if (fName.isEmpty() || fName == null || !fName.matches(cp.namePattern)) {
			System.out.println("fName : "+fName.matches(cp.namePattern));
			actionErrors.add("fName", new ActionMessage("fName"));
		}

		if (lName.isEmpty() || lName == null || !lName.matches(cp.namePattern)) {
			System.out.println("lName : "+lName.matches(cp.namePattern));
			actionErrors.add("lName", new ActionMessage("lName"));
		}

		if (email.isEmpty() || email == null || !email.matches(cp.emailPattern)) {
			System.out.println("email : "+email.matches(cp.emailPattern));
			actionErrors.add("fName", new ActionMessage("email"));
		}

		if (phoneNo.isEmpty() || phoneNo == null || !phoneNo.matches(cp.phonePattern)) {
			System.out.println("phoneno : "+phoneNo.matches(cp.phonePattern));
			actionErrors.add("phoneNo", new ActionMessage("phoneNo"));
		}

		if (password.isEmpty() || password == null) {
			System.out.println("Password");
			actionErrors.add("password", new ActionMessage("password"));
		}
		return actionErrors;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		fName = null;
		lName = null;
		phoneNo = null;
		email = null;
		type = null;
		password = null;
		noChild = 0;

	}

}

