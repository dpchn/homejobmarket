<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<html:form action="jobCreate.do" method="POST">
	Job Title :<html:text property="jobTitle" />
	<html:errors property="jobTitle" />
	<br>
	Job Descriptions :<html:textarea property="jobDes" />
	<html:errors property="jobDes" />
	<br>
	Start Date :<html:text property="startDate" />
	<html:errors property="startDate" />
	<br>
	End Date :<html:text property="endDate" />
	<html:errors property="endDate" />
	<br>
	Start Time :<html:text property="startTime" />
	<html:errors property="startTime" />
	<br>
	End Time :<html:text property="endTime" />
	<html:errors property="endTime" />
	<br>
	Pay Per Hour<html:text property="payPerHour"  />
	<html:errors property="payPerHour" />
	<br>
	<html:submit value="Post" />
	
</html:form>
