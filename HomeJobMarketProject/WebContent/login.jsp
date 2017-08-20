<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<h1>Login Page</h1>

<html:form action="auth/captureLogin.do">
	Email : <html:text property="email" />
	<font color="red"><html:errors property="email"/></font>
	<br>
	Password : <html:password property="password" />
	<font color="red"><html:errors property="password"/></font>
	<font color="red"><html:errors property="wrongPassword"/></font>
	<br>
	<html:submit value="Login" />
</html:form>