package com.hm.app.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;
import com.hm.app.form.ApplyJobForm;
import com.hm.app.service.JobService;

public class ApplyJobAction extends Action {
	ApplyJobForm applyJobForm;
	JobService applicationService = new JobService();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		applyJobForm = (ApplyJobForm) form;
			if (request.getSession() != null && request.getSession().getAttribute("type").equals("sitter")) {
				int memberId = (Integer) request.getSession().getAttribute("id");
				int jobId = applyJobForm.getJobId();
				//System.out.println("job id in apply action : " + jobId + " memerId : " + memberId);
				applicationService.applyJob(jobId, memberId);
				
				return mapping.findForward("success");
			} 
			return mapping.findForward("error");
			
			}

}
