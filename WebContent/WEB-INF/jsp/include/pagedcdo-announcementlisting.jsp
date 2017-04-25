<%@ include file="/common/taglibs.jsp"%>
<s:if test="paged.totalHits > 0">
	<table class="data-listing">
		<colgroup>
			<col width="2%" />
			<col width="5%" />
			<col width="5%" />
			<col width="13%" />
			<col />
			<col width="12%" />
			<col width="12%" />
			<col width="15%" />
			<col width="7%" />
			<col width="12%" />
			<col width="7%" />
		</colgroup>
		<thead>
			<tr>
				<td>#</td>
				<td>Status</td>
				<td>Type</td>
				<td>Title</td>
				<td>Introduction</td>
				<td>Target Group</td>
				<td>Objective</td>
				<td>Course Contents</td>
				<td>Trainers</td>
				<td>Location</td>
				<td>Deadline</td>
			</tr>
		</thead>
		<s:iterator value="paged.results" status="status">
			<tr>
				<td><s:property value="#status.count + paged.startAt" /></td>
				<td><s:if test="status!=null"><s:property value="status" /></s:if></td>
				<td><s:if test="type!=null"><s:property value="type" /></s:if></td>
				<td><s:if test="title!=null"><a href="<s:url action="profile" />?id=<s:property value="id" />">
				<s:property value="title" /></a>
				</s:if>
				<s:else>
				<a href="<s:url action="profile" />?id=<s:property value="id" />">Unspecified</a>
				</s:else>
				<br/><br/>
				<em>(<a href="<s:url action='application-list' />?announcementId=<s:property value="id" />">VIEW <s:property value="applications.size()" /> application(s)</a>)</em></td>
				<td><s:if test="introduction!=null"><iita:text value="introduction" maxLength="100" /></s:if></td>
				<td><s:if test="targetGroup!=null"><iita:text value="targetGroup" maxLength="100" /></s:if></td>
				<td><s:if test="objective!=null"><iita:text value="objective" maxLength="100" /></s:if></td>
				<td><s:if test="introduction!=null"><iita:text value="courseContents" maxLength="500" /></s:if></td>
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
				<td><s:date format="%{getText('date.format')}" name="deadline" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
	<p>No records available for CDO announcements.</p>
</s:else>