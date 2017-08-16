package com.hm.app.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hm.app.form.LoginForm;
import com.hm.app.service.UserService;

public class CaptureLoginAction extends Action{
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

		try {
			if (type.equals("seeker") && result != null) {
				httpSession.setAttribute("type", "seeker");
				return mapping.findForward("seeker");
			} else if (result != null && type.equals("sitter")) {
				httpSession.setAttribute("type", "sitter");
				return mapping.findForward("sitter");
			}
		} catch (Exception e) {
			return mapping.findForward("error");
		}
		return mapping.findForward("error");

	}

}
