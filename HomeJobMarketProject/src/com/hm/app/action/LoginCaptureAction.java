package com.hm.app.action;

import java.util.Map;

import javax.servlet.http.*;

import org.apache.struts.action.*;

import com.hm.app.form.LoginForm;
import com.hm.app.service.UserService;

public class LoginCaptureAction extends Action{
	UserService login = new UserService();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("inside capture login action....");

		LoginForm user = (LoginForm) form;
		Map<String, Object> result = login.checkUser(user.getEmail(), user.getPassword());
		HttpSession httpSession = request.getSession();
		String type = (String) result.get("type");
		result.remove("type");
		httpSession.setAttribute("id", result.get("id"));
		result.remove("id");
		httpSession.setAttribute("data", result);

			if (type.equals("seeker") && result != null) {
				//user.reset(mapping, request);
				httpSession.setAttribute("type", "seeker");
				return mapping.findForward("seeker");
			} else if (result != null && type.equals("sitter")) {
				httpSession.setAttribute("type", "sitter");
				//user.reset(mapping, request);
				return mapping.findForward("sitter");
			}
		System.out.println("Error login");
		return mapping.findForward("error");

	}

}
