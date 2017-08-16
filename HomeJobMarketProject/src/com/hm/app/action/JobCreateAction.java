package com.hm.app.action;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import com.hm.app.form.JobForm;
import com.hm.app.form.RegisterForm;
import com.hm.app.service.JobService;

public class JobCreateAction extends Action {
	JobForm job;
	JobService jobService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Inside Job Action....");
		job = (JobForm) form;
		jobService = new JobService();
		Integer jobId = 0;
		try {
			if (request.getSession() != null && request.getSession().getAttribute("type").equals("seeker")) {
				jobId = jobService.createJob((Integer) request.getSession().getAttribute("id"), job.getJobTitle(),
						job.getJobDes(), job.getStartDate(), job.getEndDate(), job.getStartTime(), job.getEndTime(),
						job.getPayPerHour());
				if (jobId > 0)
					return mapping.findForward("success");
				return mapping.findForward("error");
			} else
				return mapping.findForward("sitter");
		} catch (Exception e) {
			return mapping.findForward("error");
		}

	}
}
