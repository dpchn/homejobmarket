<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="h" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h1>Update Seeker Deatils</h1>

<h:form action="/seeker/captureUpdate.do" method="POST">

	<table>
		<c:forEach var="item" items="${updateData}">
			<tr>
				<th>First Name:</th>
					<td><h:text property="fName" value="${item.fName}" /></td>
					<td><font color="red"> <h:errors property="fName" /></font></td>
			</tr>
			<tr>
					<th>Last Name:</th>
					<td><h:text property="lName" value="${item.lName}" /></td>
					<td><font color="red"> <h:errors property="lName" /></font></td>
			</tr>
			<tr>
					<th>Mobile No:</th>
					<td><h:text property="phone" value="${item.phone}" /></td>
					<td><font color="red"> <h:errors property="phone" /></font></td>
			</tr>
			<tr>	
					<th>No of Child:</th>
					<td><h:text property="noOfChild" value="${item.noOfChild}" /></td>
					<td><font color="red"> <h:errors property="noOfChild" /></font></td>
			</tr>
			<tr>
					<th>Email Id:</th>
					<td><h:text property="email" value="${item.email}"  readonly="true"/></td>
			</tr>
				
		</c:forEach>
	</table>

	<input type="submit" value="Update" />
</h:form>

<form action="seekerProfile.do">
		<input type="submit" value="Home" />
	</form>