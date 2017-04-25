<%@ include file="/common/taglibs.jsp"%>

							
<tr>
	<td><s:url namespace="/ajax" action="public-ajax" id="xxxx" /> <iita:autocompleter cssClass="person" name="trainingProposal.trainers[%{trainerIndex}].personId" id="trainer.personId" listKey="id"
		listValue="fullName" url="%{xxxx}" method="autocompletePerson" value="%{personId}" displayValue="%{person.fullName}" /></td>
	<td><s:select name="trainingProposal.trainers[%{trainerIndex}].type" value="%{type}" list="@org.iita.trainingunit.model.Trainer$TrainerType@values()" /></td>
	<td><s:textfield name="trainingProposal.trainers[%{trainerIndex}].notes" value="%{notes}" /></td>
</tr>