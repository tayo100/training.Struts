<%@ include file="/common/taglibs.jsp"%>
<s:if test="trainees.size > 0">
	<table class="data-listing">
		<colgroup>
			<col width="2%" />
			<col width="20%" />
			<col width="13%" />
			<!-- <col width="13%" /> -->
			<col width="20%" />
			<col width="8%" />
			<col width="8%" />
			<col width="8%" />
			<col width="8%" />
		</colgroup>
		<thead>
			<tr>
				<td>#</td>
				<td>Name</td>
				<td>Supervisors</td>
				<!-- <td>Program</td> -->
				<td>University</td>
				<td>Start Date</td>
				<td>End Date</td>
				<td>Extension</td>
				<td>Last Updated</td>
			</tr>
		</thead>
		<s:iterator value="trainees" status="status">
			<tr>
				<td><s:property value="#status.count" /></td>
				<td><a href="<s:url action="trainee/profile" />?id=<s:property value="id" />"><s:property value="person.fullName" /></a></td>
				<td>
					<s:iterator value="supervisors">
						<a href="<s:url action="person/profile" />?id=<s:property value="person.id" />"><s:property value="person.fullName" /></a>; 
					</s:iterator>
				</td>
				<!-- <td><s:property value="program" /></td> -->
				<td><s:property value="university.title" /></td>
				<td><s:date format="%{getText('date.format')}" name="startDate" /></td>
				<td><s:date format="%{getText('date.format')}" name="endDate" /></td>
				<td><s:date format="%{getText('date.format')}" name="extensionDate" /></td>
				<td><s:date format="%{getText('date.format')}" name="lastUpdated" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
	<p>No records available for selected year.</p>
</s:else>