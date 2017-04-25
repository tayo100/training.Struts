<%@ include file="/common/taglibs.jsp"%>
<%-- Use this to add persons --%>
<s:form action="partner/partnerPersonContact!update" method="post">
	<s:hidden name="id" value="%{id}" />
	<table class="inputform">
		<colgroup>
			<col width="200px" />
			<col />
		</colgroup>
		<s:if test="Partner!=null">
		<tr>
			<td>Partner:</td>
			<td><s:push value="partner"><s:include value="/WEB-INF/jsp/partner/small.jsp" /></s:push></td>
		</tr>
		</s:if>
		<s:if test="person!=null">
		<tr>
			<td>Person:</td>
			<td><s:push value="person"><s:include value="/WEB-INF/jsp/person/small.jsp" /></s:push></td>
		</tr>
		</s:if>
		<tr>
			<td>Position:</td>
			<td><s:textfield name="affiliation.position" value="%{position}" /></td>
		</tr>
		<tr>
			<td>Association type:</td>
			<td><s:select name="affiliationType" value="%{type}" list="@org.iita.crm.model.PartnerPersonContact$AffiliationType@values()" listValue="%{getText('partner.partnerContact.' + toString())}" /></td>
		</tr>
		<tr>
			<td>Discipline:</td>
			<td><s:textfield name="affiliation.discipline" value="%{discipline}" /></td>
		</tr>
		<tr>
			<td>Association status:</td>
			<td><s:select name="status" value="%{status}" list="@org.iita.crm.model.PartnerPersonContact$Status@values()" listValue="%{getText('partner.partnerContact.status.' + toString())}" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Update" /> <s:submit value="Remove" action="partner/partnerPersonContact!remove" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
		</tr>
	</table>
</s:form>