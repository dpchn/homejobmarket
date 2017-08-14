package com.hm.app.service;

import com.hm.app.dao.LoginDao;
import com.hm.app.model.LoginModel;

import java.util.*;

public class LoginService {
	
	public static Map checkUser(String email, String password) {
		
		LoginDao dao = new LoginDao();
		System.out.println("insoed servie login...");
		return dao.loginUser(email, password);
	}

}
