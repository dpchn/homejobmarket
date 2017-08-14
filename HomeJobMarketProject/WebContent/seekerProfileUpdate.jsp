<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="h" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h1>Update Seeker Deatils</h1>

<h:form action="seekerUpdate.do" method="POST">
	<table>
		<tr>
			<td>
				<table>
					<tr>
						<th>First Name :</th>
					</tr>
					<tr>
						<th>Last Name :</th>
					</tr>
					<tr>
						<th>Phone No. :</th>
					</tr>
					<tr>
						<th>No of Child. :</th>
					</tr>
					<tr>
						<th>Email id:</th>
					</tr>
				</table>
			</td>
			<td>
				<table>
					<c:forEach var="item" items="${data}">
						<tr>
							<c:if test="${item.key=='email'}">
								<td><h:text property="${item.key}" value="${item.value}" readonly="readonly"/></td>
							<td></c:if>
							<c:if test="${item.key !='email'}">
							
								<td><h:text property="${item.key}" value="${item.value}" /></td>
								<td><font color="red"> <h:errors
											property="${item.key }" />
								</font></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
			</td>

		</tr>
	</table>
	<input type="submit" value="Update" />
</h:form>
