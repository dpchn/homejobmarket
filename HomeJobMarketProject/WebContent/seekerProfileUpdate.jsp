<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="h" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h1>Update Seeker Deatils</h1>

<h:form action="/seeker/captureUpdate.do" method="POST">

	<table>
		<c:forEach var="item" items="${update}">
			<tr>
				<c:if test="${item.key=='email'}">
					<th>"${item.key}"</th>
					<td><h:text property="${item.key}" value="${item.value}"
							readonly="readonly" /></td>
					
				</c:if>
				<c:if test="${item.key !='email'}">

					<th>"${item.key}"</th>
					<td><h:text property="${item.key}" value="${item.value}" /></td>
					<td><font color="red"> <h:errors
								property="${item.key }" />
					</font></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>

	<input type="submit" value="Update" />
</h:form>
