package com.hm.app.form;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.hm.app.util.ReadFileWords;

public class JobForm extends ActionForm {

	private int id;
	private String jobTitle;
	private String jobDes;
	private String startDate;
	private String endDate;
	private String startTime;
	private String endTime;
	private float payPerHour;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDes() {
		return jobDes;
	}

	public void setJobDes(String jobDes) {
		this.jobDes = jobDes;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public float getPayPerHour() {
		return payPerHour;
	}

	public void setPayPerHour(float payPerHour) {
		this.payPerHour = payPerHour;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		System.out.println("Inside.... Job Form");

		ActionErrors errors = new ActionErrors();
		if (jobTitle == null || jobTitle.isEmpty())
			errors.add("jobTitle", new ActionMessage("jobTitle"));
		if (jobDes == null || jobDes.isEmpty())
			errors.add("jobDes", new ActionMessage("jobDes"));
		if (startDate == null || startDate.isEmpty())
			errors.add("startDate", new ActionMessage("startDate"));
		if (endDate == null || endDate.isEmpty())
			errors.add("endDate", new ActionMessage("endDate"));
		if (startTime == null || startTime.isEmpty())
			errors.add("startTime", new ActionMessage("startTime"));
		if (endTime == null || endTime.isEmpty())
			errors.add("endTime", new ActionMessage("endTime"));
		if (payPerHour == 0)
			errors.add("payPerHour", new ActionMessage("payPerHour"));
		if(!JobForm.isThisDateValid(endDate))
			errors.add("endDateFormat", new ActionMessage("endDateFormat"));
		if(!JobForm.isThisDateValid(startDate))
			errors.add("startDateFormat", new ActionMessage("startDateFormat"));
		if(!JobForm.isBeforeDate(startDate, endDate))
			errors.add("dateBefore", new ActionMessage("dateBefore"));

		try {
			if (ReadFileWords.isContainsOffensiveWord(jobTitle))
				errors.add("JobTitleoffensiveword", new ActionMessage("JobTitleoffensiveword"));
			if (ReadFileWords.isContainsOffensiveWord(jobDes))
				errors.add("JobDesOffensiveword", new ActionMessage("JobDesOffensiveword"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		jobTitle = null;
		jobDes = null;
		startDate = null;
		endDate = null;
		startTime = null;
		endTime = null;
		payPerHour = 0;

	}

	
	/*
	 * Check date format
	 */
	public static boolean isThisDateValid(String dateToValidate) {
		String dateFromat = "dd-mm-yy";
		if (dateToValidate == null) {
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/*
	 * Compare two date
	 */
	
	public static boolean isBeforeDate(String startDate,String endDate ) {
		if(startDate== null || endDate==null) 
			return false;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		
		try {
			Date date1 = sdf.parse(startDate);
            Date date2 = sdf.parse(endDate);
            System.out.println("Before date"+ date1.before(date2));
            if(date1.before(date2))
            	return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
