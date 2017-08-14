package com.hm.app.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UpdateRedirectAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Inside UpdateRedirectAction....");
		RequestDispatcher rd;
		if(request.getSession().getAttribute("type").equals("seeker"))
			request.getRequestDispatcher("/seekerProfileUpdate.jsp").forward(request, response);
		else
			request.getRequestDispatcher("/sitterProfileUpdate.jsp").forward(request, response);
		
		return execute(mapping, form, request, response);
		
	}

}
