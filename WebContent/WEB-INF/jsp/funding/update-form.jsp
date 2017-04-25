<%@ include file="/common/taglibs.jsp"%>

<s:form action="update-funder" method="post">
	<s:push value="profile">
	<s:if test="top instanceof org.iita.trainingunit.model.Trainee && id!=null">
		<s:hidden name="traineeId" value="%{id}" />
	</s:if>
	<s:elseif test="top instanceof org.iita.trainingunit.model.TrainingProgram && id!=null">
		<s:hidden name="programId" value="%{id}" />
	</s:elseif>
	</s:push>
	<s:hidden name="fundingId" value="%{id}" />
	<table class="inputform">
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>Sponsor/Project:</td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter cssClass="organization" name="organizationId" id="funding.organizationId" listKey="id"
				listValue="title" url="%{xx}" method="autocompleteOrganization" submitTextTo="organizationName" displayValue="%{organization.title}" /></td>
		</tr>
		<tr>
			<td>Sponsor type:</td>
			<td><s:select name="sponsorType" list="@org.iita.trainingunit.model.Funding$SponsorType@values()" value="%{sponsorType}" /></td>
		</tr>
		<tr>
			<td>Cost Center:</td>
			<td><s:textfield name="costCenter" value="%{costCenter}" /></td>
		</tr>
		<tr>
			<td>Estimated Cost (USD):</td>
			<td><s:textfield name="estimatedCost" value="%{estimatedCost}" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Update funding" /></td>
		</tr>
	</table>
</s:form>