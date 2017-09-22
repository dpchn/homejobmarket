package com.hm.app.util;


import javax.servlet.http.*;

import org.apache.struts.action.RequestProcessor;

public class OwnRequestProcessor extends RequestProcessor {




	//private OwnRequestProcessor processor = new OwnRequestProcessor();
	@Override
	protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println(request.getServletPath());
		HttpSession session = request.getSession();

		if (request.getServletPath().contains("auth")) {
			return true;
		}
	
		if (request.getServletPath().equals("/logout.do")) {
			return true;
		}
		
		if (session != null && session.getAttribute("id") != null 
				&& request.getServletPath().contains((String)request.getSession().getAttribute("type"))) {
			return true;
		}
		
		else {
			System.out.println("else...");
			try {
				request.getRequestDispatcher("/notification.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println("Inside Reuqest Processor roles exception " + e.getMessage());
			}
		}
		return false;
	}

}
