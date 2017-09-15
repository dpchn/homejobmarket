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
	<h1 align="center">Welcome to Home Job Market Page</h1>
	<table align="center">
		<tr>
			<td>
				<table border="1" align="center">
					<tr>
						<th>First Name :</th>
						<td>${data.fName}</td>
					</tr>
					<tr>
						<th>Last Name :</th>
						<td>${data.lName}</td>
					</tr>
					<tr>
						<th>Phone No:</th>
						<td>${data.phone}</td>
					</tr>
					<tr>
						<th>Email Id :</th>
						<td>${data.email}</td>
					</tr>
				</table>

				<table align="center">
					<tr>
						<td>
							<form action="update.do" method="POST">
								<input type="submit" value="Profile Update" />
							</form>
						</td>
						<td>
							<form action="jobList.do" method="POST">
								<input type="submit" value="Search Job" />
							</form>
						</td>
					</tr>
					<tr>
						<td>
							<form action="appliedJobs.do" method="POST">
								<input type="submit" value="Show Applied Jobs" />
							</form>
						</td>
						<td>
							<form action="logout.do" method="POST">
								<input type="submit" value="Logout" />
							</form>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<form action="accountDeactivate.do" method="POST">
								<input type="submit" value="Account Deactivate" />
							</form>
						</td>
					</tr>
				</table>
			</td>
			<td>
				<table bgcolor="green">
					<c:forEach var="item" items="${logHistory}">
						<tr>
							<td>${item}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>