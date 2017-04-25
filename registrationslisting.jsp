<%@ include file="/common/taglibs.jsp"%>

<html lang="en">
<head>
    <title>IYA Registrations</title>
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
		<col width="3%" />
		<col width="7%" />
		<col width="12%" />
		<col />
		<col />
		<col width="10%" />
	</colgroup>
	<thead>
		<tr>
			<td>#</td>
			<td>Trainee Name</td>
			<td>Training Course</td>
			<td>Objectives</td>
			<td>Created By/On</td>
			<td>Updated By/On</td>
			<td></td>
			<td></td>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="paged.results" status="status">
			<tr>
				<td><s:property value="#status.count + paged.startAt" /></td>
				<td><s:property value="person.fullName" /></td>
				<td><s:property value="iyaTrainingAnnouncement.trainingCourse" /></td>
				<td><table>
					<colgroup>
						<col />
					</colgroup>
					<s:if test="iyaTrainingAnnouncement.trainingObjectives.size>0">
						<s:iterator value="iyaTrainingAnnouncement.trainingObjectives" status="status">
								<tr>
									<td>
										<s:property value="objective" />
									</td>
								</tr>
						</s:iterator>
					</s:if>
					</table></td>
					<td><s:property value="createdBy" /> - <iita:date
						name="createdDate" format="%{getText('date.format')}" /></td>
					<td>
						<s:property value="lastUpdatedBy" /> - <iita:date name="lastUpdated"
							format="%{getText('date.format')}" />
					</td>
				
				<td><a href="<s:url namespace="/iya" action="registration/appraise" />?regId=<s:property value="regId" />">Appraise</a></td>
					<td>
					<a
						href="<s:url namespace="/iya" action="registration/edit" />?regId=<s:property value="regId" />">Edit</a>
					| <a
						href="<s:url namespace="/iya" action="registration/view" />?regId=<s:property value="regId" />">View</a>
					
					| <a href="<s:url namespace="/iya" action="registration/delete" />?regId=<s:property value="regId" />" 
						onclick="javascript: return confirm('Are you sure you want to delete this record?');" >Delete</a>
					</td>
				</tr>
		</s:iterator>
	</tbody>
</table>
</s:if>
<s:else>
	<p>No registrations have been submitted</p>
</s:else>
</body>
</html>