<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Applicants</h1>
	<c:if test="${listOfApplicant.size() >0 }">
		<c:forEach items="${listOfApplicant}" var="person">
			<table border="1">
				<tr>
					<th>Name</th>
					<td>${person.Name}</td>
				</tr>
				<tr>
					<th>Phone</th>
					<td>${person.Phone}</td>
				</tr>
				<tr>
					<th>Email</th>
					<td>${person.Email}</td>
				</tr>

			</table>
			
		</c:forEach>

	</c:if>
	<c:if test="${listOfApplicant.size() <1 }">
		<c:out value="No Person has applied Yet" />
	</c:if>
	<form action="seekerProfile.do">
		<input type="submit" value="Home" />
	</form>

	<form action="showPostedJob.do">
		<input type="submit" value="Back" />
	</form>
</body>
</html>