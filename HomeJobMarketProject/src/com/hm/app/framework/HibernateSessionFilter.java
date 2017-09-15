package com.hm.app.framework;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.CallbackException;
import org.hibernate.EntityMode;
import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import com.hm.app.util.MyInterceptor;

public class HibernateSessionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Inside Filter");
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionUtil.getSession();
			transaction = session.beginTransaction();
			chain.doFilter(request, response);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Hibernate Session exception " + e.getMessage());
			RequestDispatcher requestDispatcher =  request.getRequestDispatcher("login.do");
			requestDispatcher.forward(request, response);
			transaction.rollback();
		} finally {
			session.close();
			HibernateSessionUtil.destroySession();
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
