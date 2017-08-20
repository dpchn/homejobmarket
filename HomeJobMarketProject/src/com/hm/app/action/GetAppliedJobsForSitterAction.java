package com.hm.app.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hm.app.service.JobService;

public class GetAppliedJobsForSitterAction extends Action{
JobService job = new JobService();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer userId = (Integer)request.getSession().getAttribute("id");
		request.getSession().setAttribute("appliedJobs", job.getAppliedJob(userId));
		return mapping.findForward("success");
	}
}
