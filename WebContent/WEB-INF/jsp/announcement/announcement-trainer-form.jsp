<%@ include file="/common/taglibs.jsp"%>

<tr>
	<td>Person:</td>
	<td><s:url namespace="/ajax" action="public-ajax" id="xxxx" /> <iita:autocompleter cssClass="person" name="announcement.trainers[%{trainerIndex}].personId" id="trainer.personId" listKey="id"
		listValue="fullName" url="%{xxxx}" method="autocompletePerson" value="%{personId}" displayValue="%{person.fullName}" /></td>
</tr>
<tr>
	<td>Trainer type:</td>
	<td><s:select name="announcement.trainers[%{trainerIndex}].type" value="%{type}" list="@org.iita.trainingunit.model.Trainer$TrainerType@values()" /></td>
</tr>
<tr>
	<td>Notes:</td>
	<td><s:textfield name="announcement.trainers[%{trainerIndex}].notes" value="%{notes}" /></td>
</tr>
<tr>
	<td />
	<td colspan="2"><hr size="1"></td>
</tr>