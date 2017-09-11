package com.hm.app.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hm.app.form.ApplyJobForm;
import com.hm.app.service.JobService;

public class DeleteJobCaptureAction extends Action{
	ApplyJobForm jobForm;
	JobService jobService = new JobService();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		jobForm = (ApplyJobForm)form;
		int jobId = jobForm.getJobId();
		return mapping.findForward("success");
	}

}
