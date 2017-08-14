package com.hm.app.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.*;

import org.apache.struts.action.*;
import com.hm.app.form.LoginForm;
import com.hm.app.service.LoginService;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("inside login action..");
		LoginService loginService = new LoginService();
		LoginForm user = (LoginForm) form;
		Map<String, Object> result = loginService.checkUser(user.getEmail(), user.getPassword());
		HttpSession httpSession = request.getSession();
		String type = (String) result.get("type");
		result.remove("type");
		httpSession.setAttribute("id", result.get("id"));
		result.remove("id");
		httpSession.setAttribute("data", result);
		
		for (String key : result.keySet())
			System.out.println(result.get(key));
		if (type.equals("seeker") && result != null) {
			httpSession.setAttribute("type", "seeker");
			return mapping.findForward("seeker");
		} else if (result != null && type.equals("sitter")) {
			httpSession.setAttribute("type", "sitter");
			return mapping.findForward("sitter");
		}

		return mapping.findForward("error");
	}
}
