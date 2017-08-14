package com.hm.app.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hm.app.form.RegisterForm;
import com.hm.app.service.RegisterService;
import java.util.*;
public class RegisterAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		RegisterForm user =  (RegisterForm)form;
		System.out.println(" reg Inside action...");
		RegisterService registerService = new RegisterService();
		int id = registerService.addUser(user.getfName(), user.getlName(), user.getphoneNo(), user.getEmail(), user.getPassword(), user.getType(), user.getNoChild());
		
		if(id>0) {
			System.out.println(user.getfName());
			HashMap data = new HashMap();
			data.put("fName",user.getfName());
			data.put("lName", user.getlName());
			data.put("phone", user.getphoneNo());
			data.put("email", user.getEmail());
			data.put("noOfChild", String.valueOf(user.getNoChild()));
			HttpSession httpSession = request.getSession();
			
			httpSession.setAttribute("type", user.getType());
			httpSession.setAttribute("data", data);
			httpSession.setAttribute("id", id);
			System.out.println("Id is :"+id);
			for(int i=0; i<data.size(); i++)
				System.out.println(data.get(i));
			
			if(user.getType().equals("seeker"))
				return mapping.findForward("seeker");
			else if(user.getType().equals("sitter"))
				return mapping.findForward("sitter");
			}
		return mapping.findForward("error");
	}
}
