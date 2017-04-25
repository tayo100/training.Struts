<%@ include file="/common/taglibs.jsp"%>

<s:form action="add-funder" method="post">
	<s:if test="top instanceof org.iita.trainingunit.model.Trainee && id!=null">
		<s:hidden name="traineeId" value="%{id}" />
	</s:if>
	<s:elseif test="top instanceof org.iita.trainingunit.model.TrainingProgram && id!=null">
		<s:hidden name="programId" value="%{id}" />
	</s:elseif>
	<table class="inputform">
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>Sponsor/Project:</td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter cssClass="organization" name="organizationId" id="tra.organizationId" listKey="id"
				listValue="title" url="%{xx}" method="autocompleteOrganization" submitTextTo="organizationName" /></td>
		</tr>
		<tr>
			<td>Sponsor type:</td>
			<td><s:select name="sponsorType" list="@org.iita.trainingunit.model.Funding$SponsorType@values()" /></td>
		</tr>
		<tr>
			<td>Cost Center:</td>
			<td><s:textfield name="costCenter" /></td>
		</tr>
		<tr>
			<td>Estimated Cost (USD):</td>
			<td><s:textfield name="estimatedCost" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Register funding" /></td>
		</tr>
	</table>
</s:form>