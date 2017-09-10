<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<h1>Wecome to Registration Page</h1>
<html:form action="auth/captureReg.do" method="POST"
	onsubmit="return validateregister(this);">
	<html:javascript formName="register" />
	<table>
		<tr>
			<th>First Name :</th>
			<td><html:text property="fName" /></td>
			<td> <html:errors property="fName" /> </td>

		</tr>
		<tr>
			<th>Last Name :</th>
			<td><html:text property="lName" /></td>
			<td><html:errors property="lName" /></td>
		</tr>
		<tr>
			<th>Phone No. :</th>
			<td><html:text property="phoneNo" /></td>
			<td> <html:errors property="phone" /></td>
		</tr>
		<tr>
			<th>Email id :</th>
			<td><html:text property="email" /></td>
			<td> <html:errors property="email" /></td>
		</tr>
		<tr>
			<th>Password :</th>
			<td><html:password property="password" /></td>
			<td> <html:errors property="password" /></td>
		</tr>
		<tr>
			<th>No. of Child :</th>
			<td ><html:text property="noChild" /></td>
			<td> <html:errors property="child" /></td>
		</tr>
		<tr>
			<th>Category :</th>
			<td><html:select property="type">
					<html:option value="" />
					<html:option value="seeker" />
					<html:option value="sitter" />
				</html:select>
			</td>
			<td> <html:errors property="type" /></td>
		</tr>
		<tr>
			<th ><html:submit>Register</html:submit>
			</th>
			</tr>
	</table>
</html:form>
