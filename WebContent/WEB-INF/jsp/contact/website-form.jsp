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
	<s:hidden name="type" value="org.iita.crm.model.WebsiteContact" />
	<table class="inputform">
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>URL:</td>
			<td><s:textfield name="contact.url"></s:textfield></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add URL" /></td>
		</tr>
	</table>
</s:form>