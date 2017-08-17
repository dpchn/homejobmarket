package com.hm.app.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import com.hm.app.form.UpdateForm;

public class UpdateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Inside Update Action...");
		UpdateForm updateForm = (UpdateForm) form;
		updateForm.setfName("asfsdf");
		updateForm.setlName("sdsdf");
		updateForm.setPhone("asdfsdf");
		updateForm.setEmail("some email");
		updateForm.setNoChild(3);
		Map<String, Object> data = (Map)request.getSession().getAttribute("data");
		Map<String, Object> update = new HashMap<>();
		if (request.getSession().getAttribute("update") == null
				|| request.getSession().getAttribute("data").equals("")) {
			for (String key : data.keySet()) {
				update.put(key, data.get(key));
			}

		}else {
			update.put("fName", updateForm.getfName());
			update.put("lName", updateForm.getlName());
			update.put("email", updateForm.getEmail());
			update.put("noOfChild", updateForm.getNoChild());
			update.put("phone", updateForm.getPhone());
			
		}

		request.getSession().getAttribute("update");
		return mapping.findForward("success");
	}

}
