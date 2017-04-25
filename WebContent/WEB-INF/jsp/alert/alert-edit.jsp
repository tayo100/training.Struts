<%@ include file="/common/taglibs.jsp"%>

<s:form action="alert/update" method="post">
<h2>Update Alert</h2>
	<s:push value="profile">
	<s:if test="top instanceof org.iita.trainingunit.model.Trainee && id!=null">
		<s:hidden name="traineeId" value="%{id}" />
	</s:if>
	<s:elseif test="top instanceof org.iita.trainingunit.model.TrainingProgram && id!=null">
		<s:hidden name="programId" value="%{id}" />
	</s:elseif>
	</s:push>
	<s:hidden name="alertId" value="%{id}" />
	<table class="inputform">
		<colgroup>
			<col width="15%" />
			<col />
		</colgroup>
		<tr>
			<td>Alert type:</td>
			<td><s:select name="alertType" list="@org.iita.trainingunit.model.Alert$AlertType@values()" value="%{type}" listValue="%{getText('alert.type.' + toString())}" /></td>
		</tr>
		<tr>
			<td>Subject:</td><td><s:textfield name="subject" value="%{subject}" /></td>
		</tr>
		<tr>
			<td>Body:</td><td><s:textarea name="body" value="%{body}" /></td>
		</tr>
		<tr>
			<td><label>Alert Date:</label></td>
			<td><iita:datepicker name="alertDate" format="dd/MM/yyyy" value="%{alertDate}" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Update Alert" /></td>
		</tr>
	</table>
</s:form>