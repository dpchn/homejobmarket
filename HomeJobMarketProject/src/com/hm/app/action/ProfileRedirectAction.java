package com.hm.app.action;

import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hm.app.service.LogService;

public class ProfileRedirectAction extends Action {
	LogService logService = new LogService();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.getSession().setAttribute("logHistory",
				logService.RecentActivity((Integer) request.getSession().getAttribute("id")));
		return mapping.findForward("success");
	}

}
