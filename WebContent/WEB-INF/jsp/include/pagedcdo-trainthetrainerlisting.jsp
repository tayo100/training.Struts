<%@ include file="/common/taglibs.jsp"%>
<s:if test="paged.totalHits > 0">
	<table class="data-listing">
		<colgroup>
			<col width="2%" />
			<col width="15%" />
			<col />
			<col width="18%" />
			<col width="18%" />
			<col width="15%" />
			<col width="7%" />
			<col width="7%" />
		</colgroup>
		<thead>
			<tr>
				<td>#</td>
				<td>Requestor</td>
				<td>Training Title</td>
				<td>Project Information</td>
				<td>Activity</td>
				<td>Resource Persons</td>
				<td>Training Stops</td>
				<td>Modify</td>
			</tr>
		</thead>
		<s:iterator value="paged.results" status="status">
			<tr>
				<td><s:property value="#status.count + paged.startAt" />
				</td>
				<td><a
					href="<s:url action="trainingproposal/profile" />?id=<s:property value="id" />"><s:property
							value="requestor" />
				</a>
				</td>
				<td><s:if test="trainingTitle!=null">
						<iita:text value="trainingTitle" maxLength="500" />
					</s:if>
				</td>
				<td><s:if test="projectInformation!=null">
						<iita:text value="projectInformation" maxLength="500" />
					</s:if>
				</td>
				<td><s:if test="activity!=null">
						<iita:text value="activity" maxLength="500" />
					</s:if>
				</td>
				<td><s:if test="resourcePersons!=null">
						<iita:text value="resourcePersons" maxLength="500" />
					</s:if>
				</td>
				<td><s:date format="%{getText('date.format')}"
						name="stopTrainingDate" />
				</td>
				<td><a onclick="javascript: return window.confirm('Delete this entry?');" href="<s:url action="trainingdelete" />?id=<s:property value="id" />">Delete</a>
				<a href="<s:url action="editdata" />?id=<s:property value="id" />">Edit</a>
				</td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
	<p>No records available for Scientists announcements.</p>
</s:else>