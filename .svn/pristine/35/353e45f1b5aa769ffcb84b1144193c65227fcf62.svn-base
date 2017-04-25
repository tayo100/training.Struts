<%@ include file="/common/taglibs.jsp"%>

<s:form action="partner/iitahub!updateIitaHub" method="post">
	<s:if test="top instanceof org.iita.crm.model.Partner">
	<s:hidden name="id" value="%{id}" />
	<s:hidden name="partnerId" value="%{profile.id}" />
	</s:if>
	<table class="inputform">
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>IITA hub:</td>
			<td><s:select name="hub" emptyOption="true" list="@org.iita.crm.model.PartnerIITAHub$IITAHub@values()" listValue="%{getText('partner.iitahub.' + toString())}" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add IITA hub" /></td>
		</tr>
	</table>
</s:form>