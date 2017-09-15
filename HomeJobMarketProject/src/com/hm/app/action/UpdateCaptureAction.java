package com.hm.app.action;

import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
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
			
			@SuppressWarnings("unchecked")
			Map<String, Object> obj1 = (Map<String, Object>) request.getSession().getAttribute("data");
			int child = 0;
			if(request.getSession().getAttribute("type").equals("sitter")) {
				child = Integer.valueOf(obj1.get("noOfChild").toString());
				
			}
			else
				child = Integer.valueOf(updateForm.getNoChild());
			if (request.getSession() != null) {
				res = updateService.updateData((Integer) request.getSession().getAttribute("id"), updateForm.getfName(),
						updateForm.getlName(), updateForm.getEmail(), updateForm.getPhone(), child);
			} 

			if (res) {
				
				Map<String, Object> obj = new HashMap<String, Object>();
				obj.put("fName", updateForm.getfName());
				obj.put("lName", updateForm.getlName());
				obj.put("phone", updateForm.getPhone());
				obj.put("email", updateForm.getEmail());
				obj.put("noOfChild", child);
				
				request.getSession().removeAttribute("data");
				request.getSession().setAttribute("data", obj);
				request.getSession().setAttribute("updateData", obj);
				return mapping.findForward("success");
			}
			return mapping.findForward("error");
		

	}

}
