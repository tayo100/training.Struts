<%@ include file="/common/taglibs.jsp"%>
<s:form action="contact!updateContact" method="post">
	<s:hidden name="id" value="%{id}" />
	<s:hidden name="partnerId" value="%{profile.id}" />
	<s:if test="top instanceof org.iita.crm.model.Person">
		<s:hidden name="personId" value="%{id}" />
	</s:if>
	<s:elseif test="top instanceof org.iita.crm.model.Organization">
		<s:hidden name="organizationId" value="%{id}" />
	</s:elseif>
	<s:elseif test="top instanceof org.iita.crm.model.Partner">
		<s:hidden name="partnerId" value="%{id}" />
	</s:elseif>
	<table class="rawform">
		<colgroup>
			<col width="50" />
			<col />
		</colgroup>
		<tr>
			<td>RSS Feed:</td>
			<td><s:textfield name="contact.rss" value="%{rss}" /></td>
		</tr>
		<tr>
			<td>RSS Comment:</td>
			<td><s:textfield name="contact.rssComment" value="%{rssComment}" /></td>
 		<tr>
			<td colspan="2" class="ar"><s:submit value="Update" /> <s:submit value="Delete" action="contact!remove" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
		</tr>
	</table>
</s:form>