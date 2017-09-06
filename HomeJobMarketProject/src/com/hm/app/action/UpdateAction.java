package com.hm.app.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import com.hm.app.form.UpdateForm;

public class UpdateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Inside Update Action...Fisrt ");
		UpdateForm updateForm = (UpdateForm) form;
	
		List<Integer> data = (List<Integer>)request.getSession().getAttribute("data");
		List<Object> updatelist = new ArrayList<>();
		if (request.getSession().getAttribute("updateData") == null
				|| request.getSession().getAttribute("updateData").equals("")) {
			System.out.println("Checking data in data ins Update");
			System.out.println(data);
		updatelist.addAll(data);
			
		}else {
			System.out.println("Else");
			Map<String, Object> obj = new HashMap<>();
			obj.put("fName", updateForm.getfName());
			obj.put("lName", updateForm.getlName());
			obj.put("email", updateForm.getEmail());
			obj.put("noOfChild", updateForm.getNoChild());
			obj.put("phone", updateForm.getPhone());
			updatelist.add(obj);
			System.out.println(updatelist);
		}

		request.getSession().setAttribute("updateData", updatelist);
		return mapping.findForward("success");
	}

}
