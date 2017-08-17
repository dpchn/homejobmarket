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
							<c:forEach items="${job.value}" var="item">
								<tr>
								<c:if test="${item.key!='jobId'}">
									<th>${item.key}</th>
									<td>${item.value}</td>
								</c:if>
								</tr>
							</c:forEach>
						</table>

					</td>
					<td><a href="applyJob.do?jobId=${job.key}">Apply to this
							job</a></td>
				</tr>
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
	
	
	<form action="sitterProfile.do">
		<input type="submit" value="Home" />
	</form>
</body>
</html>