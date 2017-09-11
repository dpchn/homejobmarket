package com.hm.app.form;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.hm.app.util.ConstantPattern;
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
		if (payPerHour <= 0)
			errors.add("payPerHour", new ActionMessage("payPerHour"));
		boolean startTimeValidFormat = true;
		if (startTime != null && !startTime.isEmpty() && !isThisTimeValid(startTime)) {
			System.out.println("Check 1");
			errors.add("invalidStartTime", new ActionMessage("invalidStartTime"));
			startTimeValidFormat = false;
		}
		if (endTime != null && !endTime.isEmpty() && !isThisTimeValid(endTime)) {
			errors.add("invalidEndTime", new ActionMessage("invalidEndTime"));
		
		}
		
		if (startDate != null && endDate != null && !endDate.isEmpty() && startTime != null && endTime != null
				&& !startDate.isEmpty() && startTimeValidFormat &&  !startTime.isEmpty() && !endTime.isEmpty()) {
			boolean check1 = true, check2 = true;
			if (!JobForm.isThisDateValid(endDate)) {
				check1 = false;
				errors.add("endDateFormat", new ActionMessage("endDateFormat"));
			}
			if (!JobForm.isThisDateValid(startDate)) {
				check2 = false;
				errors.add("startDateFormat", new ActionMessage("startDateFormat"));
			}
			
			if(check2 &&  !isStartDateGreaterThanCurrentDate(startDate, startTime))
				errors.add("startGreaterThanCurrent", new ActionMessage("startGreaterThanCurrent"));
			
			
			if (check1 && check2)
				if (!JobForm.isBeforeDate(startDate, endDate, startTime, endTime))
					errors.add("dateBefore", new ActionMessage("dateBefore"));
		}

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
		try {
			String dateStr[] = dateToValidate.split("-");
			if (Integer.valueOf(dateStr[0]) > 31 || Integer.valueOf(dateStr[1]) > 12)
				return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	/*
	 * Time format
	 */

	public static boolean isThisTimeValid(String timeValidate) {
		try {
			String timeStr[] = timeValidate.split(":");
			if (Integer.valueOf(timeStr[0]) > 23 || Integer.valueOf(timeStr[0]) > 59)
				return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	/*
	 * Check Start date should not less than current date
	 */
	
	public static boolean isStartDateGreaterThanCurrentDate(String startDate, String startTime){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY HH:mm");
		try {
			Date startDateTime = sdf.parse(startDate+" "+startTime);
			Date d = new Date();
			Date currentDateTime = sdf.parse(sdf.format(d));
			if (startDateTime.after(currentDateTime))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	

	/*
	 * Compare two date
	 */

	public static boolean isBeforeDate(String startDate, String endDate, String startTime, String endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY HH:mm");

		try {
			Date date1 = sdf.parse(startDate+" "+startTime);
			Date date2 = sdf.parse(endDate+" "+endTime);
			if (date1.before(date2))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
