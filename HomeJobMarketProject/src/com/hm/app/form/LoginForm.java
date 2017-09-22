package com.hm.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.hm.app.service.UserService;
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
		UserService login = new UserService();
		
		boolean emailStatus = true;
		if( email==null ||email.isEmpty() || !email.matches(pattern.emailPattern)) {
			errors.add("email" , new ActionMessage("email"));
		}
		if( password==null || password.isEmpty() )
			errors.add("password", new ActionMessage("password"));
		
		if(!login.isExit(email) &&(!email.isEmpty() && email!=null)) {
			emailStatus = false;
			errors.add("emailNotExist",new ActionMessage("emailNotExist"));
		}
		
		if( emailStatus && login.checkUser(email, password)==null && !email.isEmpty() && email!=null) {
			errors.add("wrongPassword",new ActionMessage("wrongPassword"));
		}
		
		if (!email.isEmpty() && email!=null && emailStatus)
			if(!login.isActive(email))
			errors.add("notActive",new ActionMessage("notActive"));
		return errors;
	}
	
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		email=null;
		password=null;
	}
	
}

