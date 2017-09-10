package com.hm.app.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.RequestProcessor;

public class OwnRequestProcessor extends RequestProcessor {

	private static ThreadLocal<ServletRequest> currentRequest = new ThreadLocal<ServletRequest>();
	private static ThreadLocal<ServletResponse> currentResponse = new ThreadLocal<ServletResponse>();
	
	
	
	public static ThreadLocal<ServletRequest> getCurrentRequest() {
		return currentRequest;
	}



	public static ThreadLocal<ServletResponse> getCurrentResponse() {
		return currentResponse;
	}



	//private OwnRequestProcessor processor = new OwnRequestProcessor();
	@Override
	protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		currentRequest.set(request);
		currentResponse.set(response);
	//	System.out.println(request.getServletPath());
	//	System.out.println("Session "+ session.getAttribute("id"));

		if (request.getServletPath().contains("auth")) {
			/*try {
				System.out.println("Session ()((((((((((9");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}*/
			System.out.println("Auth");
			return true;
		}
		/*if (session != null || request.getServletPath().equals("/update.do")
				&& (session.getAttribute("type").equals("seeker") || session.getAttribute("type").equals("sitter"))) {
			System.out.println("sitter");
			return true;
		}*/
		if (request.getServletPath().equals("/logout.do")) {
			return true;
		}
		if (request.getServletPath().equals("/fullLogout.do")) {
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
