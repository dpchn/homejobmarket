package com.hm.app.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hm.app.service.JobService;

public class ShowPostedJobAction extends Action{
	JobService jobService = new JobService();
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			Integer id = (Integer)request.getSession().getAttribute("id");
			List<Object> jobs = jobService.getMyPostedJob(id);
			request.getSession().setAttribute("joblist", jobs);
			System.out.println(jobs);
			return mapping.findForward("success");
	}

}
