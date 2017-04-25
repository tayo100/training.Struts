<%@ include file="/common/taglibs.jsp"%>

<s:form action="update-trainer" method="post">
	<s:push value="profile">
	<s:if test="top instanceof org.iita.trainingunit.model.Trainee && id!=null">
		<s:hidden name="traineeId" value="%{id}" />
	</s:if>
	<s:elseif test="top instanceof org.iita.trainingunit.model.TrainingProgram && id!=null">
		<s:hidden name="programId" value="%{id}" />
	</s:elseif>
	<s:elseif test="top instanceof org.iita.trainingunit.announcements.model.TrainingProposal && id!=null">
		<s:hidden name="trainingProposalId" value="%{id}" />
	</s:elseif>
	<s:elseif test="top instanceof org.iita.trainingunit.announcements.model.Announcement && id!=null">
		<s:hidden name="announcementId" value="%{id}" />
	</s:elseif>
	</s:push>
	<s:hidden name="trainerId" value="%{id}" />
	<table class="inputform">
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>Person:</td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter cssClass="person" name="personId" id="person.id" listKey="id"
				listValue="fullName" url="%{xx}" method="autocompletePerson" submitTextTo="personName" displayValue="%{person.fullName}" /></td>
		</tr>
		<tr>
			<td>Trainer type:</td>
			<td><s:select name="type" list="@org.iita.trainingunit.model.Trainer$TrainerType@values()" value="%{type}" /></td>
		</tr>
		<tr>
			<td>Notes:</td>
			<td><s:textarea name="notes" value="%{notes}" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Update" /></td>
		</tr>
	</table>
</s:form>