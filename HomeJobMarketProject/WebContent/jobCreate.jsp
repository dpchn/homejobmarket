<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<html:form action="seeker/captureJob.do" method="POST">
	Job Title :<html:text property="jobTitle" />
	<font color = 'red'><html:errors property="jobTitle"/>
	<html:errors property="JobTitleoffensiveword" />
	 </font>
	<br>
	Job Descriptions :<html:textarea property="jobDes" />
	<font color = 'red'><html:errors property="jobDes" />
	<html:errors property="JobDesOffensiveword" />
	</font>
	<br>
	Start Date :<html:text property="startDate" />
	<font color = 'red'><html:errors property="startDate" />
	<html:errors property="dateBefore" />
	<html:errors property="startDateForamt" />
	</font>
	<br>
	End Date :<html:text property="endDate" />
	<font color = 'red'>
	<html:errors property="endDateForamt" />	
	<html:errors property="endDate" /></font>
	<br>
	Start Time :<html:text property="startTime" />
	<font color = 'red'><html:errors property="startTime" />
	
	</font>
	<br>
	End Time :<html:text property="endTime" />
	<font color = 'red'><html:errors property="endTime" />
	
	</font>
	<br>
	Pay Per Hour<html:text property="payPerHour"  />
	<font color = 'red'><html:errors property="payPerHour" /></font>
	<br>
	<html:submit value="Post" />
	
</html:form>
