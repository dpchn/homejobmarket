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
		System.out.println("User id is "+userId);
		//System.out.println("Rsutl "+service.verifyJob(userId, jobId));
		ActionErrors errors = new ActionErrors();
		if(!service.verifyJob(userId, jobId) && request.getSession().getAttribute("type").equals("seeker"))
			errors.add("NotAuthorizeDelete", new ActionMessage("NotAuthorizeDelete"));
		if(!service.isJobExist(jobId) && request.getSession().getAttribute("type").equals("sitter"))
			errors.add("jobNotExist", new ActionMessage("jobNotExist"));
		return errors;
	}
	

}
