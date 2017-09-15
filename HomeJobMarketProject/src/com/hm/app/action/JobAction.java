package com.hm.app.action;

import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hm.app.form.JobForm;
import com.hm.app.service.JobService;

public class JobAction extends Action {
	JobForm job;
	JobService jobService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			return mapping.findForward("success");
	}
}
