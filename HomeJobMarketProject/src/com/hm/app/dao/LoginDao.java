package com.hm.app.dao;

import javax.management.*;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.hibernate.*;

import com.hm.app.model.LoginModel;
import com.hm.app.model.RegisterModel;
import com.hm.app.util.CreateSession;

import java.util.*;

public class LoginDao {

	public static Map<String, Object> loginUser(String email, String password) {
		System.out.println("Inside login dao...");
		Session session = CreateSession.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			List<RegisterModel> list = session.createQuery(
					"from com.hm.app.model.RegisterModel where email='" + email + "' and password='" + password + "'")
					.list();
			Map<String, Object> details = new HashMap<String, Object>();
			for (RegisterModel l : list) {
				details.put("fName", l.getfName().toString());
				details.put("lName", l.getlName().toString());
				details.put("phone", l.getphoneNo().toString());
				details.put("email", l.getEmail().toString());

				details.put("id", l.getId());
				System.out.println("Hello.." + details.size());
				if (!l.getType().equals("sitter"))
					details.put("noOfChild", l.getNoOfChild());
				details.put("type", l.getType().toString());
			}

			transaction.commit();
			session.close();

			return details;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			session.close();
			return null;
		}

	}
}
