package com.hm.app.action;

import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.http.*;

import org.apache.struts.action.*;

import com.hm.app.form.LoginForm;
import com.hm.app.service.UserService;
import com.hm.app.util.OwnRequestProcessor;

public class LoginCaptureAction extends Action {
	UserService login = new UserService();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("inside capture login action....");
		RequestDispatcher rd;
		LoginForm user = (LoginForm) form;
		ThreadLocal<ServletRequest> request2 = OwnRequestProcessor.getCurrentRequest();
		System.out
				.println("Therad Local reuqest " + OwnRequestProcessor.getCurrentRequest().get().getParameter("email"));

		Map result = login.checkUser(user.getEmail(), user.getPassword());
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
