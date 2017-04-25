<%@ include file="/common/taglibs.jsp"%>
<s:if test="paged.pageSize > 0">
	<table class="data-listing">
		<colgroup>
			<col width="2%" />
			<col width="14%" />
			<col width="10%" />
			<col width="17%" />
			<col width="7%" />
			<col width="10%" />
			<col width="12%" />
			<col width="7%" />
			<col width="7%" />
			<col width="7%" />
			<col width="7%" />
		</colgroup>
		<thead>
			<tr>
				<td>#</td>
				<td>Name</td>
				<td>Selection</td>
				<td>Research Topic</td>
				<td>Sponsor</td>
				<td>Supervisor(s)</td>
				<td>University</td>
				<td>Start Date</td>
				<td>End Date</td>
				<td>Extension</td>
				<td>Last Updated</td>
			</tr>
		</thead>
		<s:iterator value="paged.results" status="status">
			<tr>
				<td><s:property value="#status.count + paged.startAt" /></td>
				<td><a href="<s:url action="trainee/profile" />?id=<s:property value="id" />"><s:property value="person.fullName" /></a></td>
				<td>
					<s:if test="selectionService.selectedList.selectedTrainees.contains(id)">
						<s:url id="removeUrl" namespace="/selection"
							action="selection!removeTrainee">
							<s:param name="id" value="id" />
						</s:url>
						<s:a href="%{removeUrl}">Remove from Cart?</s:a>
					</s:if> <s:else>
						<s:url id="selectUrl" namespace="/selection"
							action="selection!addTrainee">
							<s:param name="id" value="id" />
						</s:url>
						<s:a href="%{selectUrl}">Add to Cart?</s:a>
					</s:else>
				</td>
				<td><s:property value="researchTopic" /></td>
				<td><s:property value="sponsor" /></td>
				<td>
					<s:iterator value="supervisors">
						<a href="<s:url action="person/profile" />?id=<s:property value="person.id" />"><s:property value="person.fullName" /></a>; 
					</s:iterator>
				</td>
				<td><s:if test="university.title != null"><s:property value="university.title" /></s:if><s:else><s:property value="university.shortName" /></s:else>
				</td>
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