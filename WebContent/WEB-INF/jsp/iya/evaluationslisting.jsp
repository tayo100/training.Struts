<%@ include file="/common/taglibs.jsp"%>

<html lang="en">
<head>
    <title>IYA Evaluations</title>
</head>
<body>

<s:include value="/WEB-INF/jsp/paging.jsp">
	<s:param name="page" value="paged.page" />
	<s:param name="pages" value="paged.pages" />
	<s:param name="pageSize" value="paged.pageSize" />
	<s:param name="href" value="%{''}" />
</s:include>
<s:hidden name="type" value="org.iita.trainingunit.model.IYAEvaluation" />
<s:if test="paged.totalHits > 0">
<table class="data-listing">

	<thead>
		<tr>
			<td>#</td>
			<td>Training Course</td>
			<td>Mastery of Subject</td>
			<td>Objectives Met</td>
			<td>Course Time</td>
			<td>Classroom Interaction</td>
			<td>Created By/On</td>
			<td>Updated By/On</td>
			<td></td>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="paged.results" status="status">
			<tr>
				<td><s:property value="#status.count + paged.startAt" /></td>
				<td><s:property value="iyaRegistration.iyaTrainingAnnouncement.trainingCourse" /></td>
				<td><s:property value="subjectMastery" /></td>
				<td><s:property value="objectivesMet" /></td>
				<td><s:property value="courseDelivery" /></td>
				<td><s:property value="classInteraction" /></td>
				<td><s:property value="createdBy" /> - <iita:date
					name="createdDate" format="%{getText('date.format')}" /></td>
				<td>
					<s:property value="lastUpdatedBy" /> - <iita:date name="lastUpdated"
						format="%{getText('date.format')}" />
				</td>
				<td><a
						href="<s:url namespace="/iya" action="evaluation/edit" />?id=<s:property value="id" />">Edit</a>
					| <a
						href="<s:url namespace="/iya" action="evaluation/view" />?id=<s:property value="id" />">View</a>
					
					| <a href="<s:url namespace="/iya" action="evaluation/delete" />?id=<s:property value="id" />" 
						onclick="javascript: return confirm('Are you sure you want to delete this record?');" >Delete</a>
					</td>
		</s:iterator>
	</tbody>
</table>
</s:if>
<s:else>
	<p>No evaluations have been submitted</p>
</s:else>
</body>
</html>