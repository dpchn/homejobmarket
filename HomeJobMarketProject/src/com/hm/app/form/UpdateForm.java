package com.hm.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.hm.app.util.ConstantPattern;

public class UpdateForm  extends ActionForm{
	private int id;
	private String fName;
	private String lName;
	private String phone;
	private String email;
	private int noOfChild;
	
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNoChild() {
		return noOfChild;
	}
	public void setNoChild(int noChild) {
		this.noOfChild = noChild;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		ConstantPattern pattern = new ConstantPattern();
		if(fName==null || fName.isEmpty() || !fName.matches(pattern.namePattern)) {
			System.out.println("fName :"+fName);
			errors.add("fName", new ActionMessage("fName"));
		}
		if(lName==null || lName.isEmpty() || !lName.matches(pattern.namePattern)) {
			errors.add("lName", new ActionMessage("lName"));
		}
		if(phone==null || phone.isEmpty() || !phone.matches(pattern.phonePattern)) {
			errors.add("phone", new ActionMessage("phone"));
		}
		
		return errors;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		fName=null;
		lName = null;
		phone = null;
		noOfChild = 0;
		super.reset(mapping, request);
	}

}
