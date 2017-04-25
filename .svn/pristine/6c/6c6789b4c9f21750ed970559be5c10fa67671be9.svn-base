<%@ include file="/common/taglibs.jsp"%>

<html lang="en">
<head>
    <title>IYA Training Announcements</title>
</head>
<body>

<s:include value="/WEB-INF/jsp/paging.jsp">
	<s:param name="page" value="paged.page" />
	<s:param name="pages" value="paged.pages" />
	<s:param name="pageSize" value="paged.pageSize" />
	<s:param name="href" value="%{''}" />
</s:include>

<s:if test="paged.totalHits > 0">
<table class="data-listing">
	<colgroup>
		<col width="2%" />
		<col width="10%" />
		<col width="10%" />
		<col />
		<col />
		<col />
		<col />
		<col width="10%" />
		<col width="10%" />
	</colgroup>
	<thead>
		<tr>
			<td>#</td>
			<td>Organizer</td>
			<td>Sponsor</td>
			<td>Course</td>
			<td>Objectives</td>
			<td>Facilitator(s)</td>
			<td>Location(s)</td>
			<td>Created By/On</td>
			<td>Updated By/On</td>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="paged.results" status="status">
			<tr>
				<td><s:property value="#status.count + paged.startAt" /></td>
				<td><s:property value="organizer" /></td>
				<td><s:property value="sponsor" /></td>
				<td><s:property value="trainingCourse" />
					<br /><a href="<s:url namespace="/iya" action="announcement/edit" />?id=<s:property value="id" />">Edit</a> | <a href="<s:url namespace="/iya" action="announcement/view" />?id=<s:property value="id" />">View</a>
				</td>
				<td>
					<s:if test="trainingObjectives.size>0">
						<ul>
						<s:iterator value="trainingObjectives" status="status">
							<li><s:property value="objective" /></li>
						</s:iterator>
						</ul>
					</s:if>
				</td>
				<td>
					<s:if test="facilitators.size>0">
						<ul>
						<s:iterator value="facilitators" status="status">
							<li><s:property value="%{person==null ? names : person.fullName}" /> <s:if test="email!=null"> (<s:property value="email" /></s:if>, <s:property value="type" />) <s:if test="notes!=null"> - <s:property value="notes" /></s:if></li>
						</s:iterator>
						</ul>
					</s:if>
				</td>
				<td>
					<s:if test="trainingLocations.size>0">
						<ul>
						<s:iterator value="trainingLocations" status="status">
							<li><s:if test="venue!=null"><s:property value="venue" /></s:if><s:if test="country!=null">, <s:property value="country" /></s:if> <s:if test="startDate!=null">(<iita:date name="startDate" format="%{getText('date.format')}" /> - <iita:date name="endDate" format="%{getText('date.format')}" />)</s:if></li>
						</s:iterator>
						</ul>
					</s:if>
				</td>
				<td>			
					<s:property value="createdBy" /> - <iita:date name="createdDate" format="%{getText('date.format')}" />
				</td>
				<td>
					<s:if test="updatedBy!=null"><s:property value="updatedBy" /> - <iita:date name="updatedDate" format="%{getText('date.format')}" /></s:if>
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>
</s:if>
<s:else>
	<p>No applications have been submitted</p>
</s:else>
</body>
</html>