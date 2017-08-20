<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Sitter Profile</h1>

	<table border="1">
		<c:forEach var="item" items="${data}">
			<tr>
				<th>First Name :</th>
				<td>${item.fName}</td>
			</tr>
			<tr>
				<th>Last Name :</th>
				<td>${item.lName}</td>
			</tr>
			<tr>
				<th>Phone No:</th>
				<td>${item.phone}</td>
			</tr>
			<tr>
				<th>Email Id :</th>
				<td>${item.email}</td>
			</tr>
		</c:forEach>
	</table>

	<form action="update.do" method="POST">
		<input type="submit" value="Profile Update" />
	</form>

	<form action="jobList.do" method="POST">
		<input type="submit" value="Search Job" />
	</form>

	<form action="appliedJobs.do" method="POST">
		<input type="submit" value="Show Applied Jobs" />
	</form>

	<form action="logout.do" method="POST">
		<input type="submit" value="Logout" />
	</form>

	<form action="accountDeactivate.do" method="POST">
		<input type="submit" value="Account Deactivate" />
	</form>


</body>
</html>