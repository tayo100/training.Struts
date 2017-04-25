<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Requestor: <s:property value="trainTheTrainer.requestor" />
</title>
</head>
<body>
<table style="width: 100%">
	<colgroup>
		<col width="200px" />
		<col />
	</colgroup>
	<tbody>
		<tr>
			<td>Unit:</td>
			<td><s:property value="trainTheTrainer.unit" /></td>
		</tr>
		<tr>
			<td>Program Director:</td>
			<td><s:property value="trainTheTrainer.programDirector" /></td>
		</tr>
		<tr>
			<td>Training Title:</td>
			<td><s:property value="trainTheTrainer.trainingTitle" /></td>
		</tr>
		<tr>
			<td>Venue:</td>
			<td><s:property value="trainTheTrainer.venue" /></td>
		</tr>
		<tr>
			<td>Cost Center:</td>
			<td><s:property value="trainTheTrainer.costCenter" /></td>
		</tr>
		<tr>
			<td>Locations:</td>
			<td><s:property value="trainTheTrainer.locations" /></td>
		</tr>
		<tr>
			<td>Duration:</td>
			<td><s:property value="trainTheTrainer.duration" /></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><s:property value="trainTheTrainer.country" /></td>
		</tr>
		<tr>
			<td>Training Budget:</td>
			<td><s:property value="trainTheTrainer.trainingBudget" /></td>
		</tr>
		<tr>
			<td>Project Information:</td>
			<td><iita:text value="trainTheTrainer.projectInformation" /></td>
		</tr>
		<tr>
			<td>Start Training Date:</td>
			<td><s:property value="trainTheTrainer.startTrainingDate" /></td>
		</tr>
		<tr>
			<td>Stop Training Date:</td>
			<td><s:property value="trainTheTrainer.stopTrainingDate" /></td>
		</tr>
		<tr>
			<td>CRP:</td>
			<td><iita:text value="trainTheTrainer.crp" /></td>
		</tr>
		<tr>
			<td>Activity:</td>
			<td><iita:text value="trainTheTrainer.activity" /></td>
		</tr>
		<tr>
			<td>Background:</td>
			<td><iita:text value="trainTheTrainer.background" /></td>
		</tr>
		<tr>
			<td>Budget Officer:</td>
			<td><s:property value="trainTheTrainer.budgetOfficer" /></td>
		</tr>
		<tr>
			<td>Training Materials:</td>
			<td><iita:text value="trainTheTrainer.trainingMaterials" /></td>
		</tr>
		<tr>
			<td>Target Participants:</td>
			<td><iita:text value="trainTheTrainer.targetParticipants" /></td>
		</tr>
		<tr>
			<td>Resource Persons:</td>
			<td><iita:text value="trainTheTrainer.resourcePersons" /></td>
		</tr>
		<tr>
			<td>Training Objectives:</td>
			<td><iita:text value="trainTheTrainer.trainingObjectives" /></td>
		</tr>
		<tr>
			<td>Expected Training Outcome:</td>
			<td><iita:text value="trainTheTrainer.expectedTrainingOutcome" /></td>
		</tr>
	</tbody>
</table>
</body>
</html>