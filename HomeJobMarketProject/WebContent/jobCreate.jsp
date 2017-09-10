<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<html:form action="seeker/captureJob.do" method="POST">
	<table>
		<tr>
			<th>Job Title :</th>
			<td><html:text property="jobTitle" /></td>
			<td><html:errors property="jobTitle" /> <html:errors
					property="JobTitleoffensiveword" /></td>
		</tr>
		<tr>
			<th>Job Descriptions :</th>
			<td><html:textarea property="jobDes" /></td>
			<td><html:errors property="jobDes" /> <html:errors
					property="JobDesOffensiveword" /></td>
		</tr>
		<tr>
			<th>Start Date (eg. dd-mm-yyyy):</th>
			<td><html:text property="startDate" /></td>
			<td><html:errors property="startDate" /> <html:errors
					property="dateBefore" /> 
					<html:errors property="startDateFormat" />
					<html:errors property="startGreaterThanCurrent" />

			</td>
		</tr>
		<tr>
			<th>End Date (eg. dd-mm-yyyy):</th>
			<td><html:text property="endDate" /></td>
			<td><html:errors property="endDateFormat" /> <html:errors
					property="endDate" /></td>
		</tr>
		<tr>
			<th>Start Time (eg. hh:mm):</th>
			<td><html:text property="startTime" /></td>
			<td><html:errors property="startTime" /> <html:errors
					property="invalidStartTime" /></td>
		</tr>
		<tr>
			<th>End Time (eg. hh:mm):</th>
			<td><html:text property="endTime" /></td>
			<td><html:errors property="endTime" /> <html:errors
					property="invalidEndTime" /></td>
		</tr>
		<tr>
			<th>Pay Per Hour($/hr):</th>
			<td><html:text property="payPerHour" /></td>
			<td><html:errors property="payPerHour" /></td>
		</tr>
	</table>
	<html:submit value="Post" />

</html:form>

<form action="seekerProfile.do">
	<input type="submit" value="Back" />
</form>

