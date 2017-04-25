<%@ include file="/common/taglibs.jsp"%>
<div style="padding: 2px 2px 3px 5px; background-color: rgb(239, 239, 239);">			
<s:form method="get" action="programs/export" namespace="/"><s:submit value="Export to Excel" /></s:form>
</div>
<s:if test="paged.pageSize > 0">
		<table class="data-listing">
				<colgroup>
					<col width="2%" />
					<col />
					<col width="10%" />
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
					<td>Selection</td>
					<td>Trainers</td>
					<!-- <td>Program</td> -->
					<td>Start Date</td>
					<td>End Date</td>
					<td>Extension</td>
					<td>Updated</td>
				</tr>
				</thead>
				<s:iterator value="paged.results" status="status">
				<tr>
					<td><s:property value="#status.count + paged.startAt" /></td>
					<td><a href="<s:url action="program/profile" />?id=<s:property value="id" />"><s:property value="title" />, <s:property value="location" /></a></td>
					<td>
						<s:if test="selectionService.selectedList.selectedTrainingPrograms.contains(id)">
						<s:url id="removeUrl" namespace="/selection"
							action="selection!removeTrainingProgram">
							<s:param name="id" value="id" />
						</s:url>
						<s:a href="%{removeUrl}">Remove from Cart?</s:a>
						</s:if> <s:else>
							<s:url id="selectUrl" namespace="/selection"
								action="selection!addTrainingProgram">
								<s:param name="id" value="id" />
							</s:url>
							<s:a href="%{selectUrl}">Add to Cart?</s:a>
						</s:else>
					</td>
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