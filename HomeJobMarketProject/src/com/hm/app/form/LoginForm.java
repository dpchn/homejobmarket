package com.hm.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.hm.app.util.ConstantPattern;

public class LoginForm extends  ActionForm{

	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		ConstantPattern pattern = new ConstantPattern();
		System.out.println("Login checkinf...");
		if(email.isEmpty() || email==null || !email.matches(pattern.emailPattern)) {
			errors.add("email" , new ActionMessage("email"));
			System.out.println("Login checkin....................");
		}
		if(password.isEmpty() || password==null )
			errors.add("password", new ActionMessage("password"));
		return errors;
	}
	
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		email=null;
		password=null;
	}
	
}

