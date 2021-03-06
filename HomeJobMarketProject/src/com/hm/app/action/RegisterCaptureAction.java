package com.hm.app.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hm.app.form.RegisterForm;
import com.hm.app.service.UserService;

public class RegisterCaptureAction extends Action {
	UserService registerService;
	RegisterForm user;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		user = (RegisterForm) form;
		System.out.println(" reg Inside action...");
		registerService = new UserService();
		int id = registerService.addUser(user.getfName(), user.getlName(), user.getphoneNo(), user.getEmail(),
				user.getPassword(), user.getType(), Integer.valueOf(user.getNoChild()));

		if (id > 0) {
			System.out.println(user.getfName());
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("fName", user.getfName());
			data.put("lName", user.getlName());
			data.put("phone", user.getphoneNo());
			data.put("email", user.getEmail());
			data.put("noOfChild", user.getNoChild());
			
	
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("type", user.getType());
			httpSession.setAttribute("data", data);
			httpSession.setAttribute("id", id);
			return mapping.findForward(user.getType());
			
		}
		return mapping.findForward("error");
	}

}
