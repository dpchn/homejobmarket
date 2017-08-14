package com.hm.app.service;

import com.hm.app.dao.RegisterDao;
import com.hm.app.dao.UpdateDao;
import com.hm.app.model.RegisterModel;

public class UpdateService {
	static RegisterModel seekerObj;
	public static boolean updateData(Integer id, String fName, String lName, String email, String phone, int noOfChild ){
		seekerObj = RegisterDao.findId(id);
		System.out.println("Id in update :"+id);
		System.out.println(id);
		System.out.println(fName);
		System.out.println(lName);
		System.out.println(email);
		System.out.println(phone);
		System.out.println("No of child:"+noOfChild);
		
		seekerObj.setfName(fName);
		seekerObj.setlName(lName);
		seekerObj.setEmail(email);
		seekerObj.setphoneNo(phone);
		seekerObj.setNoOfChild(noOfChild);
		System.out.println("Inside update data service ....");
		return UpdateDao.update(seekerObj);
	}
}
