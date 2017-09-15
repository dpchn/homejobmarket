package com.hm.app.action;

import java.util.*;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import com.hm.app.form.UpdateForm;

public class UpdateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UpdateForm updateForm = (UpdateForm) form;
	
		@SuppressWarnings("unchecked")
		Map<String, Object> data = (Map<String, Object>)request.getSession().getAttribute("data");
		Map<String, Object> updatelist = new HashMap<String, Object>();
		if (request.getSession().getAttribute("updateData") == null
				|| request.getSession().getAttribute("updateData").equals("")) {
		updatelist = data;
			
		}else {
			Map<String, Object> obj = new HashMap<>();
			obj.put("fName", updateForm.getfName());
			obj.put("lName", updateForm.getlName());
			obj.put("email", updateForm.getEmail());
			obj.put("noOfChild", updateForm.getNoChild());
			obj.put("phone", updateForm.getPhone());

			updatelist = obj;
			if(updateForm.getfName()==null ||updateForm.getlName()==null ||
					updateForm.getEmail()==null || updateForm.getNoChild()==null  || updateForm.getPhone()==null )
			updatelist = data;
		}

		request.getSession().setAttribute("updateData", updatelist);
		return mapping.findForward("success");
	}

}
