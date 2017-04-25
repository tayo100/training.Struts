<%@ include file="/common/taglibs.jsp"%>

<s:form action="contact!updateContact" method="post">
	<s:if test="top instanceof org.iita.crm.model.Person">
	<s:hidden name="personId" value="%{id}" />
	</s:if>
	<s:elseif test="top instanceof org.iita.crm.model.Organization">
	<s:hidden name="organizationId" value="%{id}" />
	</s:elseif>
	<s:elseif test="top instanceof org.iita.crm.model.Partner">
	<s:hidden name="partnerId" value="%{id}" />
	</s:elseif>
	<s:hidden name="type" value="org.iita.crm.model.RssContact" />
	<table class="inputform">
		<colgroup>
			<col width="20%" />
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>RSS Feed:</td>
			<td><s:textfield name="contact.rss" value="%{contact.rss}" /></td>
		</tr>
		<tr>
			<td>Rss Comment:</td>
			<td><s:textfield name="contact.rssComment" value="%{contact.rssComment}" /></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Submit" /></td>
		</tr>
	</table>
</s:form>