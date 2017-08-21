<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<h1>Wecome to Registration Page</h1>
<html:form action="auth/captureReg.do" method="POST"
	onsubmit="return validateregister(this);">
	<html:javascript formName="register" />
	<table>
		<tr>
			<th>First Name :</th>
			<td><html:text property="fName" /></td>
			<td><font color="red"> <html:errors property="fName" />
			</font></td>

		</tr>
		<tr>
			<th>Last Name :</th>
			<td><html:text property="lName" /></td>
			<td><font color="red"> <html:errors property="lName" />
			</font></td>
		</tr>
		<tr>
			<th>Phone No. :</th>
			<td><html:text property="phoneNo" /></td>
			<td><font color="red"> <html:errors property="phone" />
			</font></td>
		</tr>
		<tr>
			<th>Email id :</th>
			<td><html:text property="email" /></td>
			<td><font color="red"> <html:errors property="email" />
			</font></td>
		</tr>
		<tr>
			<th>Password :</th>
			<td><html:password property="password" /></td>
			<td><font color="red"> <html:errors property="password" />
			</font></td>
		</tr>
		<tr>
			<th>No. of Child :</th>
			<td colspan="2"><html:text property="noChild" /></td>
		</tr>
		<tr>
			<th>Category :</th>
			<td><html:select property="type">
					<html:option value="" />
					<html:option value="seeker" />
					<html:option value="sitter" />
				</html:select>
			</td>
			<td><font color="red"> <html:errors property="type" />
			</font></td>
		</tr>
		<tr>
			<th ><html:submit>Register</html:submit>
			</th>
			</tr>
	</table>
</html:form>
