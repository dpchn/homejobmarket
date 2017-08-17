package com.hm.app.service;


import java.util.HashMap;
import java.util.Map;

import com.hm.app.dao.UserDao;
import com.hm.app.model.User;

public class UserService {
	UserDao userDao = new UserDao();
	User user = new User();
	
	/*
	 * Register Method
	 */
	public int addUser(String fName, String lName, String phoneNo, String email, String password, String type, int noChild) {
		System.out.println("Inside service erg...");
		
		user.setfName(fName);
		user.setlName(lName);
		user.setphoneNo(phoneNo);
		user.setEmail(email);
		user.setPassword(password);
		user.setType(type);
		user.setNoOfChild(noChild);
		user.setTemporaryActive("true");
		
		return userDao.add(user);
	}
	
	
	/*
	 * Login
	 */
	
	public Map<String, Object> checkUser(String email, String password) {
		System.out.println("insoed servie login...");
		user =  userDao.loginUser(email, password);
		Map<String, Object> details = new HashMap<String, Object>();
		details.put("fName", user.getfName());
		details.put("lName", user.getlName());
		details.put("phone", user.getphoneNo());
		details.put("email", user.getEmail());
		details.put("noOfChild", user.getNoOfChild());
		details.put("id", user.getId());		
		details.put("type", user.getType().toString());
		
		return details;
	}

	
	/*
	 * Update Profile
	 */
	public boolean updateData(Integer id, String fName, String lName, String email, String phone, int noOfChild ){
		user = userDao.findId(id);
		System.out.println("Id in update :"+id);
		System.out.println(id);
		System.out.println(fName);
		System.out.println(lName);
		System.out.println(email);
		System.out.println(phone);
		System.out.println("No of child:"+noOfChild);
		
		user.setfName(fName);
		user.setlName(lName);
		user.setEmail(email);
		user.setphoneNo(phone);
		user.setNoOfChild(noOfChild);
		System.out.println("Inside update data service ....");
		return userDao.update(user);
	}
	
	/*
	 * User Deactivate
	 */
	
	public boolean deActivate(Integer id) {
		User user = userDao.findId(id);
		user.setTemporaryActive("false");
		return userDao.update(user);
	}


}
