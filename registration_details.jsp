<%@ include file="/common/taglibs.jsp"%>
<head>
	<title>IYA Registration Details</title>
</head>
<a class="btn btn-primary" href="<s:url namespace="/iya" action="registration/edit" />?id=<s:property value="id" />">Edit Registration</a> 
<a class="btn btn-primary" href="<s:url namespace="/iya" action="registrations" />">All Registrations</a>
<table class="table">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td>Trainee Name:</td>
			<td>
				<s:property value="registration.person.fullName" />
			</td>
		</tr>
		<tr>
			<td>Training Course:</td>
			<td>
				<s:property value="registration.iyaTrainingAnnouncement.trainingCourse" />
			</td>
		</tr>
		<tr>
			<td>Course Objectives:</td>
			<td>
				<table class="table">
					<colgroup>
						<col />
					</colgroup>
					<s:if test="registration.iyaTrainingAnnouncement.trainingObjectives.size>0">
						<s:iterator value="registration.iyaTrainingAnnouncement.trainingObjectives" status="status">
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
	</table>
