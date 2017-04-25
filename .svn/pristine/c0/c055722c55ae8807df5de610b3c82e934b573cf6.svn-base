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
	<s:hidden name="type" value="org.iita.crm.model.PhoneContact" />
	<table class="inputform">
		<colgroup>
			<col width="20%" />
			<col />
		</colgroup>
		<tr>
			<td>PhoneNo:</td>
			<td><s:textfield name="contact.phoneNumber"></s:textfield></td>
		</tr>
		<tr>
			<td>Rank:</td>
			<td><s:select name="contact.rank" headerKey="" headerValue="Select rank.."
						list="#{'Preferred':'Preferred', 'Second':'Second', 'Third':'Third'}"></s:select></td>
		</tr>
		<tr>
			<td>Type:</td>
			<td><s:select name="contact.type"  headerKey="" headerValue="Select type.."
						list="#{'Office':'Office', 'Mobile':'Mobile', 'Home':'Home'}"> </s:select></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit value="Add Phone Number" /></td>
		</tr>
	</table>
</s:form>