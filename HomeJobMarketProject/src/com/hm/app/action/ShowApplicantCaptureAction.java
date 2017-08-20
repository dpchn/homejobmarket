package com.hm.app.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hm.app.form.ApplyJobForm;
import com.hm.app.form.JobForm;
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
