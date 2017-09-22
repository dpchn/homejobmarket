package com.hm.app.action;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import com.hm.app.form.ApplyJobForm;
import com.hm.app.service.JobService;

public class JobUpdateAction extends Action{
	ApplyJobForm jobForm;
	JobService jobService;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		jobForm = (ApplyJobForm)form;
		request.setAttribute("updateJob", jobService.getJob(jobForm.getJobId()));
		return mapping.findForward("success");
	}

}
