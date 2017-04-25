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

<div class="col-sm-12 alert alert-info">
<a href="<s:url namespace="/iya" action="announcement" />">New Announcement</a> 
</div>

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
				<td>Title</td>
				<td>Organizer</td>
				<td>Sponsor</td>
				<td>Facilitator(s)</td>
				<td>Location(s)</td>
				<td>Updated On</td>
				<td></td>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="paged.results" status="status">
				<tr>
					<td><s:property value="#status.count + paged.startAt" /></td>
					<td><s:property value="trainingCourse" /> <br />
					<td><s:property value="organizer" /></td>
					<td><s:property value="sponsor" /></td>
					<td><s:if test="facilitators.size>0">
						<ul>
							<s:iterator value="facilitators" status="status">
								<li><s:property value="%{person==null ? names : person.fullName}" /> 
							</s:iterator>
						</ul>
					</s:if></td>
					<td><s:if test="trainingLocations.size>0">
						<ul>
							<s:iterator value="trainingLocations" status="status">
								<li><s:if test="venue!=null">
									<s:property value="venue" />
								</s:if><s:if test="country!=null">, <s:property value="country" />
								</s:if> #
								<s:if test="startDate!=null">(<iita:date
										name="startDate" format="%{getText('date.format')}" /> - <iita:date
										name="endDate" format="%{getText('date.format')}" />)</s:if></li>
							</s:iterator>
						</ul>
					</s:if></td>
					<td><iita:date name="lastUpdated" format="%{getText('date.format')}" /></td>
					<td>
						<a
							href="<s:url namespace="/iya" action="announcement/edit" />?id=<s:property value="id" />">Edit</a>
						| <a
							href="<s:url namespace="/iya" action="announcement/view" />?id=<s:property value="id" />">View</a>
						
						| <a href="<s:url namespace="/iya" action="announcement/delete" />?id=<s:property value="id" />" 
							onclick="javascript: return confirm('Are you sure you want to delete this record?');" >Delete</a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</s:if>
<s:else>
	<p>No trainings have been submitted</p>
</s:else>
</body>
</html>