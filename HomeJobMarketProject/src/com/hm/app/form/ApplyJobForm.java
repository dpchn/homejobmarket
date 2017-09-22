package com.hm.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.hm.app.service.JobService;

public class ApplyJobForm  extends ActionForm{
	private int jobId;
	JobService service = new JobService();


	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		Integer userId = (Integer) request.getSession().getAttribute("id");
		ActionErrors errors = new ActionErrors();
		if (request.getSession().getAttribute("type").equals("sitter") && !service.isJobExist(jobId)) {
			errors.add("jobNotExist", new ActionMessage("jobNotExist"));
		} else if (request.getSession().getAttribute("type").equals("seeker") && !service.verifyJob(userId, jobId)) {
			errors.add("NotAuthorizeDelete", new ActionMessage("NotAuthorizeDelete"));
		}
		return errors;
	}
}
