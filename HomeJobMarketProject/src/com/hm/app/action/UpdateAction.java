package com.hm.app.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.*;

import org.apache.struts.action.*;

import com.hm.app.form.UpdateForm;
import com.hm.app.service.UpdateService;

public class UpdateAction extends Action {
	UpdateForm updateForm;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Inside Update Action....");
		 updateForm = (UpdateForm) form;
		 System.out.println("Hpone no. is :"+updateForm.getPhone());
		boolean res = false;
		if (request.getSession() != null && request.getSession().getAttribute("type").equals("seeker")) {
			res = UpdateService.updateData((Integer) request.getSession().getAttribute("id"),
					updateForm.getfName(), updateForm.getlName(), updateForm.getEmail(), 
					updateForm.getPhone(), updateForm.getNoChild());
			
		}
		else if (request.getSession() != null && request.getSession().getAttribute("type").equals("sitter")) {
			res = UpdateService.updateData((Integer)request.getSession().getAttribute("id"),
					updateForm.getfName(), updateForm.getlName(), updateForm.getEmail(), 
					updateForm.getPhone(), updateForm.getNoChild());
		}
		
		if(res) {
			/*Map updatedData = new HashMap();
			updatedData.put("fName", updateForm.getfName());
			updatedData.put("lName", updateForm.getlName());
			updatedData.put("phone", updateForm.getPhone());
			updatedData.put("email", updateForm.getEmail());
			updatedData.put("noOfChild", updateForm.getNoChild());
			request.getSession().removeAttribute("data");
			request.getSession().setAttribute("data", updatedData);*/
			return mapping.findForward((String) request.getSession().getAttribute("type"));
		}
			return mapping.findForward("error");
		
	}

}
