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
		UpdateForm updateForm = (UpdateForm) form;
	
		Map data = (Map)request.getSession().getAttribute("data");
		Map updatelist = new HashMap();
		if (request.getSession().getAttribute("updateData") == null
				|| request.getSession().getAttribute("updateData").equals("")) {
			System.out.println("Checking data in data ins Update");
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
			System.out.println(updatelist);
		}

		request.getSession().setAttribute("updateData", updatelist);
		return mapping.findForward("success");
	}

}
