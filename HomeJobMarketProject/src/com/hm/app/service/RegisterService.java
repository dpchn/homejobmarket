package com.hm.app.service;

import com.hm.app.dao.JobDao;
import com.hm.app.dao.RegisterDao;
import com.hm.app.model.RegisterModel;

public class RegisterService {
	public static int addUser(String fName, String lName, String phoneNo, String email, String password, String type, int noChild) {
		RegisterModel registerModel = new RegisterModel();
		System.out.println("Inside service erg...");
		
		registerModel.setfName(fName);
		registerModel.setlName(lName);
		registerModel.setphoneNo(phoneNo);
		registerModel.setEmail(email);
		registerModel.setPassword(password);
		registerModel.setType(type);
		registerModel.setNoOfChild(noChild);
		
		return RegisterDao.add(registerModel);
	}

}
