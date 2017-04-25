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
				<td>Requester</td>
				<td>Title</td>
				<td>Project Information</td>
				<td>Activity</td>
				<td>Locations</td>
				<td>Trainers</td>
				<td>Action</td>
			</tr>
		</thead>
		<s:iterator value="paged.results" status="status">
			<tr>
				<td><s:property value="#status.count + paged.startAt" /></td>
				<td><s:property	value="requester.fullName" /></td>
				<td>
					<strong><s:property	value="status" />:</strong> 
					<s:if test="title!=null">
						<a href="<s:url action="trainingproposal-details" />?id=<s:property value="id" />"><iita:text value="title" maxLength="500" /></a>
					</s:if>
				</td>
				<td><s:if test="projectInformation!=null">
						<iita:text value="projectInformation" maxLength="150" removeHTML="true" addDots="true" />
					</s:if>
				</td>
				<td><s:if test="activity!=null">
						<iita:text value="activity" maxLength="150" removeHTML="true" addDots="true" />
					</s:if>
				</td>
				<td>
				<s:if test="trainingLocations!=null">
						<ul>
							<s:iterator value="trainingLocations">
								<li><s:property value="venue" />, <s:property value="country" /> <s:date format="%{getText('date.format')}"
							name="startDate" />-<s:date format="%{getText('date.format')}" name="endDate" /> <strong>(<s:property value="duration" />)</strong></li>
							</s:iterator>
						</ul>
					</s:if>
					<s:else>
						No locations information found.
					</s:else>
				</td>
				<td>
				
					<s:if test="trainers!=null">
						<ul>
							<s:iterator value="trainers">
								<li><s:include value="/WEB-INF/jsp/trainer/trainingproposalsmall.jsp" /></li>
							</s:iterator>
						</ul>
					</s:if>
					<s:else>
						No trainer information found.
					</s:else>
				</td>
				<td><a onclick="javascript: return window.confirm('Delete this entry?');" href="<s:url action="trainingproposaldelete" />?id=<s:property value="id" />">Delete</a>
				<s:if test="status==@org.iita.trainingunit.announcements.model.TrainingProposal$STATUS@SUBMITTED">
					<a href="<s:url action="proposaldetails" />?id=<s:property value="id" />">Manage</a>
				</s:if>
				<s:else>
					<a href="<s:url action="proposaleditdata" />?id=<s:property value="id" />">Edit</a>
				</s:else>
				</td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
	<p>No records available from training proposals.</p>
</s:else>