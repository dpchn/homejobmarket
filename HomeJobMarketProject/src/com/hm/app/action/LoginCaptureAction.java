package com.hm.app.action;

import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import org.apache.struts.action.*;

import com.hm.app.form.LoginForm;
import com.hm.app.service.UserService;

public class LoginCaptureAction extends Action {
	UserService login = new UserService();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("inside capture login action....");
		RequestDispatcher rd;
		LoginForm user = (LoginForm) form;
		
			System.out.println("Email is exist");
			List<Object> result = login.checkUser(user.getEmail(), user.getPassword());
			HttpSession httpSession = request.getSession();
			if (result != null) {
				Integer id = (Integer) result.get(0);
				String type = (String) result.get(1);
				result.remove(0);
				result.remove(0);
				httpSession.setAttribute("id", id);
				httpSession.setAttribute("data", result);
				System.out.println("Data at loign tim " + result);
				httpSession.setAttribute("type", type);
				return mapping.findForward(type.toString().trim());
			}
	
		return mapping.findForward("error");
	}

}
