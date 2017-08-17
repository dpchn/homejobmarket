<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<h1>Login Page</h1>

<html:form action="auth/captureLogin.do">
	Email : <html:text property="email" />
	<html:errors property="email"/>
	<br>
	Password : <html:password property="password" />
	<html:errors property="password"/>
	<br>
	<html:submit value="Login" />
</html:form>