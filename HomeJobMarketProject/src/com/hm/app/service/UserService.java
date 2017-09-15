package com.hm.app.service;

import java.util.*;

import com.hm.app.dao.*;
import com.hm.app.model.*;
import java.security.*;

public class UserService {
	UserDao userDao = new UserDao();
	User user = new User();
	JobDao jobDao = new JobDao();

	public boolean isExit(String email) {
		return userDao.isExist(email);
	}

	public boolean isActive(String email) {
		if (userDao.isActive(email).equals("false"))
			return false;
		return true;
	}

	/*******************************
	 * Register Method
	 * ************************
	 */
	public int addUser(String fName, String lName, String phoneNo, String email, String password, String type,
			int noChild) {
		String SALT = "SECRETE";
		String saltedPassword = SALT + password;
		String hashedPassword = generateHash(saltedPassword);

		user.setfName(fName);
		user.setlName(lName);
		user.setphoneNo(phoneNo);
		user.setEmail(email);
		user.setPassword(hashedPassword);
		user.setType(type);
		user.setNoOfChild(noChild);
		user.setTemporaryActive("true");
		if (!userDao.isExist(email))
			return userDao.add(user);
		else
			return 0;
	}

	/****************************************************8
	 * Login
	 * **************************************************
	 */

	public Map checkUser(String email, String password) {
		String SALT = "SECRETE";
		String saltedPassword = SALT + password;
		String hashedPassword = generateHash(saltedPassword);
		user = userDao.loginUser(email, hashedPassword);
		if (user == null)
			return null;
		
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

	/*********************************************
	 * Update Profile
	 * *******************************************
	 */
	public boolean updateData(Integer id, String fName, String lName, String email, String phone, int noOfChild) {
		user = userDao.findId(id);
		user.setfName(fName);
		user.setlName(lName);
		user.setEmail(email);
		user.setphoneNo(phone);
		user.setNoOfChild(noOfChild);
		return userDao.update(user, id);
	}

	
	/*************************************************
	 * User Account Deactivate
	 * ***********************************************
	 */

	public boolean deActivate(Integer id, String type) {
		User user = userDao.findId(id);
		user.setTemporaryActive("false");
		if (type.equals("seeker")) {
		user.getJobs().stream().forEach(x->x.setTemporaryActive("false"));
		}
		return userDao.update(user, id);
	}

	public List<Object> getNoOfApplicantForApplication(Integer jobId) {
		List<Application> application = jobDao.getNoOfApplicantforJob(jobId);
		List<Object> applicants = new ArrayList<>();
		application.stream().forEach(x -> {
			User user = x.getApplyBy();
			Map<String, Object> userObj = new HashMap();
			userObj.put("Name", user.getfName());
			userObj.put("Phone", user.getphoneNo());
			userObj.put("Email", user.getEmail());
			applicants.add(userObj);

		});

		return applicants;
	}

	/**********************************************************************
	 * Hashing Fucntion
	 * ****************************************
	 */

	public String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}
		return hash.toString();
	}

}
