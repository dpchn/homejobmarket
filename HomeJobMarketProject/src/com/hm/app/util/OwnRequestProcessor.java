package com.hm.app.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.RequestProcessor;

public class OwnRequestProcessor extends RequestProcessor {

	@Override
	protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		System.out.println(request.getServletPath());
		System.out.println();
		if (request.getServletPath().contains("auth")) {
			System.out.println("Login...");
			return true;
		}
		if (request.getServletPath().equals("/update.do")
				&& (session.getAttribute("type").equals("seeker") || session.getAttribute("type").equals("sitter"))) {

			return true;
		}
		if (request.getServletPath().equals("/logout.do")) {

			return true;
		}
		if (session != null && session.getAttribute("id") != null && request.getServletPath().contains("sitter")
				&& request.getSession().getAttribute("type").equals("sitter")) {
			System.out.println("sitter...");
			return true;
		}
		if (session != null && session.getAttribute("id") != null && request.getServletPath().contains("seeker")
				&& request.getSession().getAttribute("type").equals("seeker"))
			return true;
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
