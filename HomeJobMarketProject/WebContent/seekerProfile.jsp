
<%@page import="org.omg.CosNaming.IstringHelper"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Welcome to Home Job Market Place</h1>
	<table align="center">
		<tr>
			<td>
				<table border="1">
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

					<tr>
						<th>No of Child :</th>
						<td>${data.noOfChild}</td>
					</tr>
				</table>


				<table align="center">
					<tr>
						<td>
							<form action="job.do" method="post">
								<input type="submit" value="Post Job" />
							</form>

						</td>
						<td>
							<form action="update.do" method="POST">
								<input type="submit" value="Profile Update" />
							</form>

						</td>
					</tr>
					<tr>
						<td>
							<form action="showPostedJob.do" method="POST">
								<input type="submit" value="show Posted Job" />
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


