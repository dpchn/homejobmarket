<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="h" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h1>Update Seeker Deatils</h1>

<h:form action="/seeker/captureUpdate.do" method="POST">

	<table>
			<tr>
				<th>First Name:</th>
					<td><h:text property="fName" value="${updateData.fName}" /></td>
					<td> <h:errors property="fName" /></td>
			</tr>
			<tr>
					<th>Last Name:</th>
					<td><h:text property="lName" value="${updateData.lName}" /></td>
					<td> <h:errors property="lName" /></td>
			</tr>
			<tr>
					<th>Mobile No:</th>
					<td><h:text property="phone" value="${updateData.phone}" /></td>
					<td> <h:errors property="phone" /></td>
			</tr>
			<tr>	
					<th>No of Child:</th>
					<td ><h:text property="noChild" value="${updateData.noOfChild}" /></td>
					<td> <h:errors property="child" /></td>
			</tr>
			<tr>
					<th>Email Id:</th>
					<td><h:text property="email" value="${updateData.email}"  readonly="true"/></td>
			</tr>
	</table>

	<input type="submit" value="Update" />
</h:form>

<form action="seekerProfile.do">
		<input type="submit" value="Home" />
	</form>