package com.hm.app.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class JobPageRedirectAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		System.out.println("Inside jobb page redirect....");
		try {
		if(session.getAttribute("type").equals("seeker") && session!=null)
			return mapping.findForward("seeker");
		else if(session.getAttribute("type").equals("sitter") && session!=null)
			return mapping.findForward("sitter");
		}catch (Exception e) {
			return mapping.findForward("error");
		}
		return mapping.findForward("error");
		
	}

}
