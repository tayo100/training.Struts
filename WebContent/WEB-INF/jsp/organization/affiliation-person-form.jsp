<%@ include file="/common/taglibs.jsp"%>
<%-- Use this to add persons --%>
<s:form action="organization/profile!addAffiliation" method="post">
	<s:hidden name="id" value="%{id}" />
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td>Affiliation type:</td>
			<td><s:select name="affiliationType" list="@org.iita.crm.model.Affiliation$AffiliationType@values()" listValue="%{getText('organization.affiliation.' + toString())}" /></td>
		</tr>
		<tr>
			<td>Person:</td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter cssClass="person" name="personId" id="aff.personId" listKey="id"
				listValue="fullName" url="%{xx}" method="autocompletePerson" submitTextTo="personName" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add affiliation" /></td>
		</tr>
	</table>
</s:form>