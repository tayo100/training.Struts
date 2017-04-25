<%@ include file="/common/taglibs.jsp"%>

<s:form action="alert/add" method="post">
<h2>Add Alert</h2>
	<s:if test="top instanceof org.iita.trainingunit.model.Trainee && id!=null">
		<s:hidden name="traineeId" value="%{id}" />
	</s:if>
	<s:elseif test="top instanceof org.iita.trainingunit.model.TrainingProgram && id!=null">
		<s:hidden name="programId" value="%{id}" />
	</s:elseif>
	<table class="inputform">
		<colgroup>
			<col width="15%" />
			<col />
		</colgroup>
		<tr>
			<td>Alert type:</td>
			<td><s:select name="alertType" list="@org.iita.trainingunit.model.Alert$AlertType@values()" /></td>
		</tr>
		<tr>
			<td>Subject:</td><td><s:textfield name="subject" /></td>
		</tr>
		<tr>
			<td>Body:</td><td><s:textarea name="body" /></td>
		</tr>
		<tr>
			<td><label>First Alert Date:</label></td>
			<td><iita:datepicker name="firstAlert"	format="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<td><label>Second Alert Date:</label></td>
			<td><iita:datepicker name="lastAlert" format="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add Alert" /></td>
		</tr>
	</table>
</s:form>