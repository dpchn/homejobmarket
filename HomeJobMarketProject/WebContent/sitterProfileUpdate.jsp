
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Update Sitter Details</h1>

<html:form action="/sitter/captureUpdate.do" method="POST">
	
				<table>
					<c:forEach var="item" items="${data}">
						<tr>
							<c:if test="${item.key=='email'}">
								<th>"${item.key}"</th><td><html:text property="${item.key}" 
										value="${email}" readonly="readonly" /></td>
							</c:if>
							<c:if test="${item.key !='email'}">
								<th>"${item.key}"</th><td><html:text property="${item.key}" 
									value="${item.value}" /></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
	<input type="submit" value="Update" />
</html:form>
