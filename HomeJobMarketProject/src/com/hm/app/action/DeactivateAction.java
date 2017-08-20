package com.hm.app.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hm.app.service.UserService;

public class DeactivateAction extends Action{

	UserService user = new UserService();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(request.getSession()!=null) {
			
		}
		if(request.getSession()!=null) {
			Integer id = (Integer)request.getSession().getAttribute("id");
			boolean result= user.deActivate(id,(String)request.getSession().getAttribute("type") );
			if(result) {
				request.getSession().removeAttribute("type");
				request.getSession().removeAttribute("data");
				request.getSession().removeAttribute("joblist");
				return mapping.findForward("success");
			}
		}
		return super.execute(mapping, form, request, response);
	}
}
