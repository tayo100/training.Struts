<%@ include file="/common/taglibs.jsp"%>
<s:if test="trainingPrograms.size > 0">
		<table class="data-listing">
				<colgroup>
					<col width="2%" />
					<col />
					<col width="23%" />
					<!-- <col /> -->
					<col width="7%" />
					<col width="7%" />
					<col width="7%" />
					<col width="5%" />
				</colgroup>
				<thead>
				<tr>
					<td>#</td>
					<td>Title</td>
					<td>Trainers</td>
					<!-- <td>Program</td> -->
					<td>Start Date</td>
					<td>End Date</td>
					<td>Extension</td>
					<td>Updated</td>
				</tr>
				</thead>
				<s:iterator value="trainingPrograms" status="status">
				<tr>
					<td><s:property value="#status.count" /></td>
					<td><a href="<s:url action="program/profile" />?id=<s:property value="id" />"><s:property value="title" />, <s:property value="location" /></a></td>
					<td>
						<s:iterator value="trainers">
							<a href="<s:url action="person/profile" />?id=<s:property value="person.id" />"><s:property value="person.fullName" /></a>; 
						</s:iterator>
					</td>
					<!-- <td><s:property value="program" /></td> -->
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