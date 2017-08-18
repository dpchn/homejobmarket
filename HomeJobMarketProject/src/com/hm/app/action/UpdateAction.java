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
		System.out.println("Inside Update Action :"+ updateForm.getNoChild());
		System.out.println("Inside Update Action :"+ updateForm.getfName());
		Map<String, Object> data = (Map)request.getSession().getAttribute("data");
		Map<String, Object> updateData = new HashMap();
		if (request.getSession().getAttribute("updateData") == null
				|| request.getSession().getAttribute("updateData").equals("")) {
			System.out.println("Checking data in data ins Update");
			for (String key : data.keySet()) {
				updateData.put(key, data.get(key));
			}

		}else {
			updateData.put("fName", updateForm.getfName());
			updateData.put("lName", updateForm.getlName());
			updateData.put("email", updateForm.getEmail());
			updateData.put("noOfChild", updateForm.getNoChild());
			updateData.put("phone", updateForm.getPhone());
		}

		request.getSession().setAttribute("updateData", updateData);
		return mapping.findForward("success");
	}

}
