<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<h1>Wecome to Registration Page</h1>
<html:form action="/visitor/reg" method="POST" onsubmit="return validateregister(this);">
<html:javascript formName="register"/>
	First Name :<html:text property="fName" />
		<font color="red">
			<html:errors property="fName" />
		</font>
		<br>
	Last Name :<html:text property="lName" />
		<font color="red">
			<html:errors property="lName" />
		</font>
		<br>
	Phone No. :<html:text property="phoneNo" />
		<font color="red">
			<html:errors property="phoneNo" />
		</font>
		<br>
	Email id :<html:text property="email" />
		<font color="red">
			<html:errors property="email" />
		</font>
		<br>
	Password :<html:password property="password" />
		<font color="red">
			<html:errors property="password" />
		</font>
		<br>
	 No. of Child :<html:text property="noChild" />
	 <br>
	Category :<html:select property="type">
		<html:option value="" />
		<html:option value="seeker" />
		<html:option value="sitter" />
	</html:select>
	<br>
	<html:submit>Register</html:submit>
</html:form>
