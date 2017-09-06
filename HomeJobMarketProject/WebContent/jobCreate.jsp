<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<html:form action="seeker/captureJob.do" method="POST">
<table>
	<tr><th>
	Job Title :</th><td><html:text property="jobTitle" /></td>
	<td>
	<font color = 'red'><html:errors property="jobTitle" />
	<html:errors property="JobTitleoffensiveword" />
	 </font>
	 </td>
	</tr>
	<tr>
	<th>
	Job Descriptions :</th><td><html:textarea property="jobDes" /></td>
	<td>
	<font color = 'red'><html:errors property="jobDes" />
	<html:errors property="JobDesOffensiveword" />
	</font>
	</td>
	</tr>
	<tr>
	<th>
	Start Date (eg. dd-mm-yyyy):</th> <td><html:text property="startDate" /></td>
	<td>
	<font color = 'red'><html:errors property="startDate" />
	<html:errors property="dateBefore" />
	<html:errors property="startDateFormat" />
	</font>
	</td>
	</tr>
	<tr>
	<th>
	End Date (eg. dd-mm-yyyy):</th><td><html:text property="endDate" /></td>
	<td>
	<font color = 'red'>
	<html:errors property="endDateFormat" />	
	<html:errors property="endDate" /></font>
	</td>
	</tr>
	<tr>
	<th>
	Start Time (eg. hh:mm):</th><td><html:text property="startTime" /></td>
	<td>
	<font color = 'red'><html:errors property="startTime" />
	</font>
	</td>
	</tr>
	<tr>
	<th>
	End Time (eg. hh:mm):</th><td><html:text property="endTime" /></td>
	<td>
	<font color = 'red'><html:errors property="endTime" />
	</font>
	</td>
	</tr>
	<tr>
	<th>
	Pay Per Hour($/hr):</th><td><html:text property="payPerHour" /></td>
	<td>
	<font color = 'red'><html:errors property="payPerHour" /></font>
	</td>
	</tr>
</table>
	<html:submit value="Post" />
	
</html:form>

<form action="seekerProfile.do">
		<input type="submit" value="Back" />
	</form>

