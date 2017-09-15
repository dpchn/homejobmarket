package com.hm.app.action;

import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.hm.app.form.LoginForm;
import com.hm.app.service.UserService;

public class LoginCaptureAction extends Action {
	UserService login = new UserService();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm user = (LoginForm) form;
	
		Map<String, Object> result = login.checkUser(user.getEmail(), user.getPassword());
		HttpSession httpSession = request.getSession();
		if (result != null) {
			Integer id = (Integer) result.get("id");
			String type = (String) result.get("type");
			result.remove("id");
			result.remove("type");
			httpSession.setAttribute("id", id);
			httpSession.setAttribute("data", result);
			httpSession.setAttribute("type", type);
			return mapping.findForward(type.toString().trim());
		}

		return mapping.findForward("error");
	}

}
