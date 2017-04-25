<%@ include file="/common/taglibs.jsp"%>

<s:form action="add-trainer" method="post">
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
	<table class="inputform">
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>Person:</td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xxxx" /> <iita:autocompleter cssClass="person" name="personId" id="trainer.personId" listKey="id"
				listValue="fullName" url="%{xxxx}" method="autocompletePerson" submitTextTo="personName" /></td>
		</tr>
		<tr>
			<td>Trainer type:</td>
			<td><s:select name="type" list="@org.iita.trainingunit.model.Trainer$TrainerType@values()" /></td>
		</tr>
		<tr>
			<td>Notes:</td>
			<td><s:textarea name="notes" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Register trainer" /></td>
		</tr>
	</table>
</s:form>