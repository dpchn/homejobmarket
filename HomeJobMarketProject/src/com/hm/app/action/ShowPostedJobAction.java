package com.hm.app.action;

import java.util.List;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hm.app.service.JobService;

public class ShowPostedJobAction extends Action{
	JobService jobService = new JobService();
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			Integer id = (Integer)request.getSession().getAttribute("id");
			List<Object> jobs = jobService.getMyPostedJob(id);
			request.getSession().setAttribute("joblist", jobs);
			return mapping.findForward("success");
	}

}
