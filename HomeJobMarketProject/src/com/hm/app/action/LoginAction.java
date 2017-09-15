package com.hm.app.action;


import javax.servlet.http.*;
import org.apache.struts.action.*;

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("success");

	}
}
