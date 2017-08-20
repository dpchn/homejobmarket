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
	<h1>Job List</h1>
	<c:if test="${joblist.size() > 0 }">
		<table>
			<c:forEach items="${joblist}" var="job">
				<tr>
					<td>
						<table>
							<tr>
								<th>Job Title :</th>
								<td>${job.jobTitle}</td>
							</tr>
							<tr>
								<th>Job Description :</th>
								<td>${job.jobDes}</td>
							</tr>
							<tr>
								<th>Start Date :</th>
								<td>${job.startDate}</td>
							</tr>
							<tr>
								<th>End Date :</th>
								<td>${job.endDate}</td>
							</tr>
							<tr>
								<th>Pay($/hr) :</th>
								<td>${job.payPerHour}</td>
							</tr>
							<tr>
								<th>Job Title :</th>
								<td>${job.jobTitle}</td>
							</tr>
						</table>
					<td>
					<td>
						<table>
							<tr>
								<td><a href="applyJob.do?jobId=${job.jobId}">Apply</a></td>
							</tr>
						</table>
				<tr>
					<td colspan="2"><c:out
							value="__________________________________________________"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<c:if test="${joblist.size() < 1 }">
		<h1>No Job Available</h1>
	</c:if>


	<form action="sitterProfile.do">
		<input type="submit" value="Home" />
	</form>
</body>
</html>