<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>You are ${type} can not do this.</h1>
	<p>
		Please login create account as
		<c:if test="${type=='seeker' }">
			<c:out value="sitter "></c:out>
			<form action="seeker/logout.do" method="POST">
		<input type="submit" value="Logout" />
	</form>
		</c:if>

		<c:if test="${type=='sitter'}">
			<c:out value="seeker "></c:out>
			<form action="sitter/logout.do" method="POST">
		<input type="submit" value="Logout" />
	</form>
		</c:if>
		then login.
</body>
</html>