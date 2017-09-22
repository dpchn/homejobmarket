<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Job List</h1>
	<h6>
		<html:errors property="NotAuthorizeDelete" />
	</h6>
	<c:if test="${joblist.size() > 0 }">
		<tr>
			<td>
				<table>
					<c:forEach items="${joblist}" var="job">
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
						</table>
						</td>
						<td>
							<table>
								<tr>
									<td><a href="deleteJob.do?jobId=${job.jobId}">Delete
											this job</a></td>
									<td><a href="showApplicant.do?jobId=${job.jobId}">Show
											Applicant</a></td>
									<td><a href="jobUpdate.do?jobId=${job.jobId}">Update</a></td>
								</tr>
							</table>
						</td>

						<tr>
							<td colspan="2">
								<h4>________________________________________________________________________________</h4>
							</td>
						</tr>

					</c:forEach>
				</table>
	</c:if>

	<c:if test="${joblist.size() < 1 }">
		<h1>No Job Available</h1>
	</c:if>


	<form action="seekerProfile.do">
		<input type="submit" value="Home" />
	</form>
</body>
</html>