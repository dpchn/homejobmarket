
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Update Sitter Details</h1>

<form action="sitterUpdate.do" method="POST">
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

				</table>
			</td>
			<td>
				<table>
					<c:forEach var="item" items="${data}">
						<tr>
							<c:if test="${item.key=='email'}">
								<td><html:text property="${item.key}" 
										value="${item.value}" readonly="readonly" /></td>
							</c:if>
							<c:if test="${item.key !='email'}">
								<td><html:text property="${item.key}" 
									value="${item.value}" /></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
	<input type="submit" value="Update" />
</form>
