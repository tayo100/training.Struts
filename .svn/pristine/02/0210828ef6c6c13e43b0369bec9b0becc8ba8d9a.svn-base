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
	<s:hidden name="type" value="org.iita.promis.model.BankAccountContact" />
	<table class="rawform">
		<colgroup>
			<col width="50" />
			<col />
		</colgroup>
		<tr>
			<td>Bank:</td>
			<td><s:textfield name="contact.bankName" value="%{bankName}" /></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><s:textarea id="contact_bankaddress" name="contact.bankAddress" value="%{bankAddress}" /></td>
		</tr>
		<tr>
			<td>Account name:</td>
			<td><s:textfield id="contact_accname" name="contact.accountName" value="%{accountName}" /></td>
		</tr>
		<tr>
			<td>Account No:</td>
			<td><s:textfield name="contact.accountNumber" value="%{accountNumber}" /></td>
		</tr>
		<tr>
			<td>Swift:</td>
			<td><s:textfield name="contact.swift" value="%{swift}" /></td>
		</tr>
		<tr>
			<td>IBAN:</td>
			<td><s:textfield name="contact.iban" value="%{iban}" /></td>
		</tr>
		<tr>
			<td>Notes:</td>
			<td><s:textarea name="contact.notes" value="%{notes}" cssClass="sizable-textarea" /></td>
		</tr>
		<tr>
			<td colspan="2" class="ar"><s:submit value="Update" /> <s:submit value="Delete" action="contact!remove" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
		</tr>
	</table>
</s:form>
 