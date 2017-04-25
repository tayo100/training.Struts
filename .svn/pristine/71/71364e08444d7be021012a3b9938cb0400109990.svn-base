<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Advanced Search</title>
</head>
<body>
<s:form method="post" action="advanced/search!query">
	<label>Search from:</label>
	<s:checkboxlist
		list="#{'org.iita.crm.model.Contact':'Contact information','org.iita.trainingunit.model.TrainingProgram':'Training programs','org.iita.trainingunit.model.Trainee':'Trainee','org.iita.crm.model.Trainer':'Trainer','org.iita.crm.model.Organization':'Organization'}"
		name="specify_places" value="%{indexer.indexTable}" label="Scope" />
	<br />
	<br />
		Criteria:<br />
	<table class="inputform">
		<colgroup>
			<col width="200" />
			<col />
		</colgroup>
		<tr>
			<td>Supervisor:</td>
			<td><s:textfield name="supervisor" /></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><s:textfield name="country" /></td>
		</tr>
		<tr>
			<td>Organization:</td>
			<td><s:textfield name="organisation" /></td>
		</tr>
		<tr>
			<td>Trainee:</td>
			<td><s:textfield name="trainee" /></td>
		</tr>
		<tr>
			<td>Program:</td>
			<td><s:textfield name="program" /></td>
		</tr>
		<tr>
			<td>From:</td>
			<td><iita:datepicker name="fromDate" format="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<td>To:</td>
			<td><iita:datepicker name="toDate" format="dd/MM/yyyy" /></td>
		</tr>
	</table>
	<br />
	<s:submit value="Search" />

</s:form>
</body>
</html> 