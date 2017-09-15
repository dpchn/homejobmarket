package com.hm.app.action;

import java.util.List;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hm.app.form.ApplyJobForm;
import com.hm.app.service.UserService;

public class ShowApplicantCaptureAction extends Action{
	UserService userService = new UserService();
	ApplyJobForm jobForm = new ApplyJobForm();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		jobForm = (ApplyJobForm)form;
		int jobId = jobForm.getJobId();
		List<Object> listOfApplicant =  userService.getNoOfApplicantForApplication(jobId);
		request.getSession().setAttribute("listOfApplicant", listOfApplicant);
		return mapping.findForward("success");
	}
}
