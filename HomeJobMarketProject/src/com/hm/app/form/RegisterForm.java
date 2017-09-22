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
	private String noChild;
	private String type;
	private enum checkType {
		seeker, sitter
	};

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNoChild() {
		return noChild;
	}

	public void setNoChild(String noChild) {
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
			actionErrors.add("fName", new ActionMessage("fName"));
		}

		if (lName.isEmpty() || lName == null || !lName.matches(cp.namePattern)) {
			actionErrors.add("lName", new ActionMessage("lName"));
		}

		if (email.isEmpty() || email == null || !email.matches(cp.emailPattern)) {
			actionErrors.add("email", new ActionMessage("email"));
		}

		if (phoneNo.isEmpty() || phoneNo == null || !phoneNo.matches(cp.phonePattern)) {
			actionErrors.add("phone", new ActionMessage("phone"));
		}

		if (password.isEmpty() || password == null) {
			actionErrors.add("password", new ActionMessage("password"));
		}
		if(type==null || type.isEmpty())
			actionErrors.add("type", new ActionMessage("type"));
		
		if(noChild==null || noChild.isEmpty() || noChild.matches(cp.namePattern)){
			System.out.println("No of child is "+ noChild);
			actionErrors.add("child", new ActionMessage("child"));
		}
		return actionErrors;
	}


	
	/*
	 * Check type
	 */
	static boolean checkType(String type) {
		for (checkType c : checkType.values())
			if (c.name().equals(type))
				return false;
		return true;
	}

}

