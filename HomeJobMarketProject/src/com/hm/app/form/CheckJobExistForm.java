package com.hm.app.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.hm.app.service.JobService;

public class CheckJobExistForm extends ActionForm{
	JobService service = new JobService();
	private int jobId;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if(!service.isJobExist(jobId))
			errors.add("job Not Exist", new ActionMessage("jobNotExist"));
		return super.validate(mapping, request);
	}
}
