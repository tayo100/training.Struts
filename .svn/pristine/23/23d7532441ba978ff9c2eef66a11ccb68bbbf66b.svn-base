<%@ include file="/common/taglibs.jsp"%>
<s:form action="contact!updateContact" method="post">
	<s:hidden name="id" value="%{id}" />
	<s:hidden name="partnerId" value="%{profile.id}" />
	<table class="rawform">
		<colgroup>
			<col width="50" />
			<col />
		</colgroup>
		<tr>
			<td class="ar">Phone:</td>
			<td><s:textfield name="contact.phoneNumber" value="%{phoneNumber}" /></td>
		</tr>
		<tr>
			<td class="ar">Rank:</td>
			<td><s:select name="contact.rank" headerKey="" headerValue="Select rank.."
						list="#{'Preferred':'Preferred', 'Second':'Second', 'Third':'Third'}" value="%{rank}"></s:select>
			</td>
		</tr>
		<tr>
			<td class="ar">Type:</td>
			<td><s:select name="contact.type"  headerKey="" headerValue="Select type.."
						list="#{'Office':'Office', 'Mobile':'Mobile', 'Home':'Home'}" value="%{type}"> </s:select></td>
		</tr>
		<tr>
			<td colspan="2" class="ar"><s:submit value="Update" /> <s:submit value="Delete" action="contact!remove" cssClass="button-delete" onclick="javascript: return confirm('Are you sure you want to remove this record?');" /></td>
		</tr>
	</table>
</s:form>