<%@ include file="/common/taglibs.jsp"%>
<%-- Use this to add persons --%>
<s:form action="partner/profile!addPartnerContact" method="post">
	<s:hidden name="id" value="%{id}" />
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td>Association type:</td>
			<td><s:select name="affiliationType" list="@org.iita.crm.model.PartnerPersonContact$AffiliationType@values()" listValue="%{getText('partner.partnerContact.' + toString())}" /></td>
		</tr>
		<tr>
			<td>Person:</td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter cssClass="person" name="personId" id="aff.personId" listKey="id"
				listValue="fullName" url="%{xx}" method="autocompletePerson" submitTextTo="personName" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add association" /></td>
		</tr>
	</table>
</s:form>