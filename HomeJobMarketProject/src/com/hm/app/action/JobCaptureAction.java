package com.hm.app.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hm.app.form.JobForm;
import com.hm.app.service.JobService;

public class JobCaptureAction extends Action{
	JobForm job;
	JobService jobService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		job = (JobForm) form;
		jobService = new JobService();
		Integer jobId = 0;
		
			if (request.getSession() != null && request.getSession().getAttribute("type").equals("seeker")) {
				jobId = jobService.createJob((Integer) request.getSession().getAttribute("id"), job.getJobTitle(),
						job.getJobDes(), job.getStartDate(), job.getEndDate(), job.getStartTime(), job.getEndTime(),
						job.getPayPerHour());
				
				if (jobId > 0) {
					job.reset(mapping, request);
					return mapping.findForward("success");
				}
				
				return mapping.findForward("error");
		
			}
			return mapping.findForward("error");
	}

}
