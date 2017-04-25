<%@ include file="/common/taglibs.jsp"%>
<%-- Use this to add persons --%>
<s:form action="person/profile!addAffiliation" method="post">
	<s:hidden name="id" value="%{id}" />
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<tr>
			<td>Association type:</td>
			<td><s:select name="affiliationType" list="@org.iita.crm.model.partnerPersonContact$AffiliationType@values()" listValue="%{getText('partner.partnerContact.' + toString())}" /></td>
		</tr>
		<tr>
			<td>Partner:</td>
			<td><s:url namespace="/ajax" action="public-ajax" id="xx" /> <iita:autocompleter cssClass="partner" name="partnerId" id="aff.partnerId" listKey="id"
				listValue="fullTitle" url="%{xx}" method="autocompletePartner" submitTextTo="partnerName" /></td>
		</tr>
		<tr>
			<td>Position:</td>
			<td><s:textfield name="affiliation.position" value="%{position}" /></td>
		</tr>
		<tr>
			<td>Association status:</td>
			<td><s:select name="affiliation.status" value="%{status}" list="@org.iita.crm.model.PartnerPersonContact$Status@values()" listValue="%{getText('partner.partnerContact.status.' + toString())}" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add affiliation" /></td>
		</tr>
	</table>
</s:form>