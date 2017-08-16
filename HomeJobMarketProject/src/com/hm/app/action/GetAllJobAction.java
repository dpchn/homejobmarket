package com.hm.app.action;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import com.hm.app.service.JobService;

import java.util.*;

public class GetAllJobAction extends Action {
	JobService getJobList = new JobService();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (request.getSession() != null && request.getSession().getAttribute("type").equals("sitter")) {
			Map result = getJobList.getAllJob((Integer) request.getSession().getAttribute("id"));
			request.getSession().setAttribute("joblist", result);
			System.out.println("Inside joblist....action");
			return mapping.findForward((String) request.getSession().getAttribute("type"));
		} else {
			return mapping.findForward("seeker");
		}
	}

}
