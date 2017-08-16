package com.hm.app.action;

import java.util.HashMap;
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
	UserService updateService =new UserService();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Inside Update Capture Action....");
		updateForm = (UpdateForm) form;
		System.out.println("No of childs in action ::"+ updateForm.getNoChild());
		boolean res = false;
		try {
			if (request.getSession() != null && request.getSession().getAttribute("type").equals("seeker")) {
				res = updateService.updateData((Integer) request.getSession().getAttribute("id"), updateForm.getfName(),
						updateForm.getlName(), updateForm.getEmail(), updateForm.getPhone(), updateForm.getNoChild());

			} else if (request.getSession() != null && request.getSession().getAttribute("type").equals("sitter")) {
				res = updateService.updateData((Integer) request.getSession().getAttribute("id"), updateForm.getfName(),
						updateForm.getlName(), updateForm.getEmail(), updateForm.getPhone(), updateForm.getNoChild());
			}

			if (res) {
				Map<String, Object> updatedData = new HashMap();
				updatedData.put("fName", updateForm.getfName());
				updatedData.put("lName", updateForm.getlName());
				updatedData.put("phone", updateForm.getPhone());
				updatedData.put("email", updateForm.getEmail());
				updatedData.put("noOfChild", updateForm.getNoChild());
				System.out.println("Updated Child no " + updateForm.getNoChild());
				request.getSession().removeAttribute("data");
				request.getSession().setAttribute("data", updatedData);
				return mapping.findForward((String) request.getSession().getAttribute("type"));
			}
		} catch (Exception e) {
			System.out.println("Exception in Update Action "+ e.getMessage());
			return mapping.findForward("error");
		}
		return mapping.findForward("error");

	}


}
