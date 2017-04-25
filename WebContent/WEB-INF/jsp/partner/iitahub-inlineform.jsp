<%@ include file="/common/taglibs.jsp"%>
<s:form action="partner/iitahub!updateIitaHub" method="post">
	<s:hidden name="id" value="%{id}" />
	<s:hidden name="partnerId" value="%{profile.id}" />
	<table class="rawform">
		<colgroup>
			<col width="50" />
			<col />
		</colgroup>
		<tr>
			<td>IITA hub:</td>
			<td><s:select name="hub" value="%{hub}" list="@org.iita.crm.model.PartnerIITAHub$IITAHub@values()" listValue="%{getText('partner.iitahub.' + toString())}" /></td>
		</tr>
		<tr>
			<td colspan="2" class="ar"><s:submit value="Update" /> <s:submit value="Delete" action="partner/iitahub!removeIitaHub" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
		</tr>
	</table>
</s:form>