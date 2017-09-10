package com.hm.app.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hm.app.form.UpdateForm;
import com.hm.app.service.UserService;

public class UpdateCaptureAction extends Action {
	UpdateForm updateForm;
	UserService updateService = new UserService();

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		updateForm = (UpdateForm) form;
		boolean res = false;
			request.getSession().removeAttribute("updateData");
			
			if (request.getSession() != null) {
				res = updateService.updateData((Integer) request.getSession().getAttribute("id"), updateForm.getfName(),
						updateForm.getlName(), updateForm.getEmail(), updateForm.getPhone(), Integer.valueOf(updateForm.getNoChild()));
			} 

			if (res) {
				Map updatedDataList = new HashMap();
				Map<String, Object> obj = new HashMap();
				obj.put("fName", updateForm.getfName());
				obj.put("lName", updateForm.getlName());
				obj.put("phone", updateForm.getPhone());
				obj.put("email", updateForm.getEmail());
				obj.put("noOfChild", updateForm.getNoChild());
				updatedDataList = obj;
				request.getSession().removeAttribute("data");
				request.getSession().setAttribute("data", updatedDataList);
				return mapping.findForward("success");
			}
			return mapping.findForward("error");
		

	}

}
