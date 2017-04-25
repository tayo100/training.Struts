<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>IYA Announcement form</title>
</head>
<a class="btn btn-primary" href="<s:url namespace="/iya" action="announcement/edit" />?id=<s:property value="id" />">Edit Announcement</a> 
<table class="table">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td>Sponsor:</td>
			<td>
				<s:property value="announcement.sponsor" />
			</td>
		</tr>
		<tr>
			<td>Organizer:</td>
			<td>
				<s:property value="announcement.organizer" />
			</td>
		</tr>
		<tr>
			<td>Training Objectives:</td>
			<td>
				<table class="table">
					<colgroup>
						<col />
					</colgroup>
					<s:if test="announcement.trainingObjectives.size>0">
						<s:iterator value="announcement.trainingObjectives" status="status">
								<tr>
									<td>
										<s:property value="objective" />
									</td>
								</tr>
						</s:iterator>
					</s:if>
				</table>
			</td>
		</tr>
		<tr>
			<td>Training Course/Module:</td>
			<td><s:property value="announcement.trainingCourse" /></td>
		</tr>
		<tr>
					<td valign="top">Location/Venue Information:</td>
					<td>
						<table class="table">
								    <colgroup>
								    	<col width="2%" />
										<col width="28%" />
										<col width="43%" />
										<col width="13%" />
										<col width="12%" />
									</colgroup>
									<thead>
										<tr>
											<th align="left">#</th>
											<th align="left">Country</th>
											<th align="left">Venue/Location:</th>
											<th align="left">Starts:</th>
											<th align="left">Ends:</th>
										</tr>
									</thead>
									<s:if test="announcement.trainingLocations.size>0">
										<s:iterator value="announcement.trainingLocations" status="status">
											<tr>
												<td><s:property value="#status.count" />.</td>
												<td><s:property value="country" /></td>
												<td><s:property value="venue" /></td>
								                <td><iita:date name="startDate" format="%{getText('date.format')}" /></td>
								                <td><iita:date name="endDate" format="%{getText('date.format')}" /></td>
								            </tr>
										</s:iterator>
									</s:if>
						</table>
					</td>
				</tr>
				<tr>
					<td valign="top">Facilitators/Trainers:</td>
					<td>		
					<table class="table">
						<colgroup>
							<col width="2%" />
							<col width="38%" />
							<col width="25%" />
							<col width="15%" />
							<col />
						</colgroup>
						<thead>
							<tr>
								<th align="left">#</th>
								<th align="left">Person</th>
								<th align="left">Email</th>
								<th align="left">Type</th>
								<th align="left">Note</th>
							</tr>
						</thead>
						<s:if test="announcement.facilitators.size>0">
							<s:iterator value="announcement.facilitators" status="status">
								<tr>
									<td><s:property value="#status.count" />.</td>
									<td><s:property value="%{person==null ? names : person.fullName}" /></td>
									<td><s:property value="email" /></td>
									<td><s:property value="type" /></td>
									<td><s:property value="notes" /></td>
								</tr>
							</s:iterator>
						</s:if>
					</table>
					</td>
				</tr>
	</table>