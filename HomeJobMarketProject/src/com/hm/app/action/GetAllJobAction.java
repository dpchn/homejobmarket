package com.hm.app.action;

import javax.servlet.http.*;
import org.apache.struts.action.*;
import java.util.*;
import java.util.Map.Entry;

import com.hm.app.service.GetJobListService;

public class GetAllJobAction extends Action {
	GetJobListService getJobList;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> result = getJobList.getAllJob();
		for(Entry<String, Object> m: result.entrySet())
			System.out.println(m.getValue());
		if (request.getSession() != null && request.getSession().getAttribute("type").equals("sitter")) {
			request.getSession().setAttribute("joblist", result);
			System.out.println("Inside joblist....action");
			return mapping.findForward((String) request.getSession().getAttribute("type"));
		}else {
			return mapping.findForward("seeker");
		}
	}

}
