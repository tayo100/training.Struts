<%@ include file="/common/taglibs.jsp"%>

<s:form action="add-trainee" method="post">
	<s:if test="top instanceof org.iita.crm.model.Person && id!=null">
		<s:hidden name="personId" value="%{id}" />
	</s:if>
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<s:if test="!(top instanceof org.iita.crm.model.Person && id!=null)">
			<tr>
				<td>Person:</td>
				<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter cssClass="person" name="personId" id="trainee.personId" listKey="id"
					listValue="fullName" url="%{xx}" method="autocompletePerson" submitTextTo="personName" /></td>
			</tr>
		</s:if>
		<tr>
			<td>Research Topic:</td>
			<td><s:textfield name="researchTopic" /></td>
		</tr>
		<tr>
			<td>Start date:</td>
			<td><iita:datepicker name="startDate" format="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<td>End date:</td>
			<td><iita:datepicker name="endDate" format="dd/MM/yyyy" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Register trainee" /></td>
		</tr>
	</table>
</s:form>