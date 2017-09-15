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
	<h1 align="center">Applied Josbs</h1>
	<c:if test="${appliedJobs.size() > 0 }">
		<table align="center">
			<c:forEach items="${appliedJobs}" var="job">

				<tr>
					<td>
						<table>
							<c:forEach items="${job.value}" var="item">
								<tr>
									<c:if test="${item.key != 'status'}">
										<th>${item.key}:</th>
										<td>${item.value}</td>
									</c:if>

									<c:if test="${item.key == 'status'}">
										<th>Status :</th>
										<c:if test="${item.value == 'ACTIVE'}">
											<td bgcolor="green">${item.value}</td>
										</c:if>
										<c:if test="${item.value != 'ACTIVE'}">
											<td bgcolor="red">${item.value}</td>
										</c:if>
									</c:if>
								</tr>
							</c:forEach>
						</table>

						<h4>______________________________________________________________________</h4>
					</td>
				</tr>

			</c:forEach>
		</table>
	</c:if>

	<c:if test="${appliedJobs.size() < 1 }">
		<h1>No Job Applied</h1>
	</c:if>


	<form action="sitterProfile.do">
		<input type="submit" value="Home" />
	</form>

</body>
</html>